package fr.fms;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		generateDatas();
	}

	private void generateDatas() {

		Category family = categoryRepository.save(new Category(0, "Family", "Contacts familiaux", null));
		Category friends = categoryRepository.save(new Category(0, "Friends", "Amis proches", null));
		Category work = categoryRepository.save(new Category(0, "Work", "Contacts professionnels", null));


		contactRepository.save(new Contact(0,"Michael", "Jordan", "michael.jordan@example.com", "1234567890", "123 Main St", "Ami d'enfance", family));
		contactRepository.save(new Contact(0, "Conor", "McGregor", "conor.mcgregor@example.com", "0987654321", "456 Park Ave", "Collègue de travail", work));
		contactRepository.save(new Contact(0, "Jon", "Jones", "jon.jones@example.com", "1112223333", "789 Elm St", "Camarade de classe", friends));
	}
}



