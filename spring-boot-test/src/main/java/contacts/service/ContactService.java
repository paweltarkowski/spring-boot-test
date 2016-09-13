package contacts.service;

import java.util.List;

import contacts.model.entity.ContactDto;

public interface ContactService {

	List<ContactDto> findAll();

	void save(ContactDto contactDto);
}
