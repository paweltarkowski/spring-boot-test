package contacts.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import contacts.Application;
import contacts.model.entity.ContactDto;
import contacts.service.ContactService;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
@ContextConfiguration(classes = { Application.class })
public class ContactControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ContactService contactService;

	@Test
	public void shouldIncludeContacts() throws Exception {
		given(this.contactService.findAll())
				.willReturn(Arrays.asList(ContactDto.builder().firstName("TEST_NAME").build()));

		this.mvc.perform(get("/").accept(MediaType.TEXT_HTML)).andExpect(status().isOk())
				.andExpect(model().attributeExists("contacts"));
	}

	@Test
	public void shouldSaveContact() throws Exception {
		this.mvc.perform(post("/").accept(MediaType.TEXT_HTML)).andExpect(status().is3xxRedirection());
	}

}
