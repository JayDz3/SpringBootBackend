package com.jaydz.javaspringbootrest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.jaydz.javaspringbootrest.data.UserRepository;
import com.jaydz.javaspringbootrest.models.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void whenFindByEmail_thenReturnEmail() {
		User user = new User();
		user.setFirstName("jason");
		user.setLastName("dz");
		user.setEmail("test@yahoo.com");
		user.setPassword("password");
		user.setIsLoggedIn(false);
		user.setStayLoggedIn(false);
		user.setEmailConfirmed(false);
		entityManager.persist(user);
		entityManager.flush();
		
		// when
		String found = userRepo.getByEmail(user.getEmail());
		
		// then
		assertThat(found)
		.isEqualTo(user.getEmail());
	}
}
