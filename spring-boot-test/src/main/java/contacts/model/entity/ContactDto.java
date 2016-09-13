package contacts.model.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
}
