package hh.BookStore.BookStore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.BookStore.BookStore.domain.User;
import hh.BookStore.BookStore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {

	@Autowired
	private UserRepository urepo;
	
	@Test
	public void findByUserNameShouldReturnUser() {
		User user = urepo.findByUsername("admin");
		
		assertThat(user).isNotNull();
	}
	
	@Test
	public void createNewUser(){
		User user = new User("test", "qwerty", "test");
		urepo.save(user);
		assertThat(user.getId()).isNotNull();
	}
	@Test
	public void deleteUser(){
		User user = new User("test", "qwerty", "test");
		urepo.save(user);
		assertThat(user.getId()).isNotNull();
		
		urepo.delete(user.getId());
		user = urepo.findByUsername("test");
		assertThat(user).isNull();
	}
}
