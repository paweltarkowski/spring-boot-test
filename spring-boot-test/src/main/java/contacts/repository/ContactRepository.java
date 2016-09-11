package contacts.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import contacts.model.Contact;

@Repository
public class ContactRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Contact> findAll() {
		return jdbcTemplate.query(
				"select id, firstName, lastName, phoneNumber, emailAddress from contacts order by lastName",
				(ResultSet rs, int rowNum) -> {
					Contact contact = new Contact();
					contact.setId(rs.getLong(1));
					contact.setFirstName(rs.getString(2));
					contact.setLastName(rs.getString(3));
					contact.setPhoneNumber(rs.getString(4));
					contact.setEmailAddress(rs.getString(5));
					return contact;
				});

	}

	public void save(Contact contact) {
		jdbcTemplate.update("insert into contacts (firstName, lastName, phoneNumber, emailAddress) values (?, ?, ?, ?)",
				contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmailAddress());
	}

}
