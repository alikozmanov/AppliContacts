package fr.fms.business;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IBusinessImpl implements IBusiness {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Contact> getContacts() throws Exception {
        return contactRepository.findAll();
    }

    @Override
    public Page<Contact> getContactsPages(String kw, int page) throws Exception {
        return contactRepository.findByFirstNameContainingOrLastNameContaining(kw, kw, PageRequest.of(page, 5));
    }

    @Override
    public Contact getContactById(Long id) throws Exception {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        return optionalContact.orElse(null);
    }

    @Override
    public void saveContact(Contact contact) throws Exception {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) throws Exception {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Category> getCategories() throws Exception {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }
}
