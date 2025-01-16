package fr.fms.business;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import fr.fms.entities.Category;
import fr.fms.entities.Contact;

import java.util.List;

@Service
public interface IBusiness {
    List<Contact> getContacts() throws Exception;

    Page<Contact> getContactsPages(String kw, int page) throws Exception;

    Contact getContactById(Long id) throws Exception;

    void saveContact(Contact contact) throws Exception;

    void deleteContact(Long id) throws Exception;

    List<Category> getCategories() throws Exception;

    Category getCategoryById(Long id) throws Exception;
}
