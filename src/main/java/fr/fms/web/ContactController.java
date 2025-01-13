package fr.fms.web;

import fr.fms.dao.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/index")
    public String index() {
        return "contacts";
    }
}
