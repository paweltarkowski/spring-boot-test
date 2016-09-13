package contacts.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@SequenceGenerator(name = "contact_sequence", sequenceName = "contact_id_seq", initialValue = 1, allocationSize = 1)
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_sequence")
	private Long id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String phoneNumber;

	@Column
	private String emailAddress;
}
