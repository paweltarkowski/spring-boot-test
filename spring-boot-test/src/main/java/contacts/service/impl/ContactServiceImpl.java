package contacts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contacts.model.domain.Contact;
import contacts.model.entity.ContactDto;
import contacts.repository.ContactRepository;
import contacts.service.ContactService;
import ma.glasnost.orika.MapperFacade;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private MapperFacade mapper;

	@Autowired
	private ContactRepository contactRepository;

	public List<ContactDto> findAll() {
		return mapper.mapAsList(contactRepository.findAll(), ContactDto.class);
	}

	@Transactional
	public void save(ContactDto contactDto) {
		final Contact contact = mapper.map(contactDto, Contact.class);
		contactRepository.save(contact);
	}
}
