package fr.fms.web;

import fr.fms.dao.ContactRepository;
import fr.fms.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactController {
    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/index")
        public String index (Model model){
            List<Contact> contacts = contactRepository.findAll();
            model.addAttribute("listContact", contacts);

            return "contacts";
        }
}

