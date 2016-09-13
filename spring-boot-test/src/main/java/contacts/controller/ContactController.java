package contacts.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import contacts.model.entity.ContactDto;
import contacts.service.ContactService;

@Controller
@RequestMapping("/")
public class ContactController {

	@Autowired
	ContactService contactService;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Map<String, Object> model) {
		final List<ContactDto> contacts = contactService.findAll();
		model.put("contacts", contacts);
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(ContactDto contact) {
		contactService.save(contact);
		return "redirect:/";
	}
}
