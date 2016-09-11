package contacts.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import contacts.model.Contact;
import contacts.repository.ContactRepository;

@Controller
@RequestMapping("/")
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Map<String, Object> model) {
		final List<Contact> contacts = contactRepository.findAll();
		model.put("contacts", contacts);
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Contact contact) {
		contactRepository.save(contact);
		return "redirect:/";
	}
}
