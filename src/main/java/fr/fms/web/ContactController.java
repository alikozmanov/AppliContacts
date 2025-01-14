package fr.fms.web;

import fr.fms.dao.ContactRepository;
import fr.fms.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "keyword", defaultValue = "") String kw) {
        // Recherche avec mot-clé
        Page<Contact> contacts = contactRepository.findByFirstNameContainingOrLastNameContaining(kw, kw, PageRequest.of(page, 5));

        model.addAttribute("listContact", contacts.getContent());
        model.addAttribute("pages", new int[contacts.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw); // Pour remplir avec le mot-clé

        return "contacts";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id,
                         @RequestParam(name = "page") int page,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        // Vérifier si l'ID existe avant de le supprimer
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
        }

        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }
}


