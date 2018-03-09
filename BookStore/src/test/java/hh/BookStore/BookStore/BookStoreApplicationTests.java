package hh.BookStore.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.BookStore.BookStore.webcontroller.BookStoreController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {
	@Autowired
	private BookStoreController contr;
	
	@Test
	public void controlLoads() throws Exception {
		 assertThat(contr).isNotNull();
	}
	
	@Test
	public void contextLoads() {
	}

}
