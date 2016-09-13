package contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contacts.model.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	// @Autowired
	// private JdbcTemplate jdbcTemplate
	//
	// public List<Contact> findAll() {
	// return jdbcTemplate.query(
	// "select id, firstName, lastName, phoneNumber, emailAddress from contacts
	// order by lastName",
	// (ResultSet rs, int rowNum) -> {
	// Contact contact = new Contact();
	// contact.setId(rs.getLong(1));
	// contact.setFirstName(rs.getString(2));
	// contact.setLastName(rs.getString(3));
	// contact.setPhoneNumber(rs.getString(4));
	// contact.setEmailAddress(rs.getString(5));
	// return contact;
	// });
	//
	// }
	//
	// public void save(Contact contact) {
	// jdbcTemplate.update("insert into contacts (firstName, lastName,
	// phoneNumber, emailAddress) values (?, ?, ?, ?)",
	// contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(),
	// contact.getEmailAddress());
	// }

}
