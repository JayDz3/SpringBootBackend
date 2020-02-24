package com.jaydz.javaspringbootrest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.jaydz.javaspringbootrest.data.UserRepository;
import com.jaydz.javaspringbootrest.models.User;
import com.jaydz.javaspringbootrest.service.DatabaseService;
import com.jaydz.javaspringbootrest.service.DatabaseServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {
		
		@Bean
		public DatabaseService service() {
			return new DatabaseServiceImpl();
		}
	}
	
	@Autowired
	private DatabaseService service;
	
	@MockBean
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
		User u = new User();
		u.setFirstName("jason");
		u.setLastName("dz");
		u.setEmail("test@yahoo.com");
		u.setPassword("password");
		u.setEmailConfirmed(false);
		u.setIsLoggedIn(false);
		u.setStayLoggedIn(false);
		
		Mockito.when(userRepository.getByEmail(u.getEmail()))
		.thenReturn(u.getEmail());
	}
	
	@Test
	public void whenEmailTaken_thenReturnEmail() {
		String email = "test@yahoo.com";
		String found = userRepository.getByEmail(email);
		
		assertThat(found)
		.isEqualTo(email);
	}
	

}
