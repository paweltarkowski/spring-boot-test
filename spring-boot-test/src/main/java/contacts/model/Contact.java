package contacts.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Contact {
	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
}
