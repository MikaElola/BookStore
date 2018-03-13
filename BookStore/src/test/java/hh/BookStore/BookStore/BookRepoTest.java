package hh.BookStore.BookStore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.BookStore.BookStore.domain.Category;
import hh.BookStore.BookStore.domain.Book;
import hh.BookStore.BookStore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepoTest {

	@Autowired
	private BookRepository brepo;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = brepo.findByTitle("1984");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
	}
	
	@Test
	public void createNewBook(){
		Book book = new Book("Test", "Test", 123, 123, 10.00, new Category("Test"));
		brepo.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteBook(){
		
		long bookId = 1; 
		Book book = brepo.findOne(bookId);
		brepo.delete(book);
		
		List<Book> books = (List<Book>) brepo.findAll();
		assertThat(books).hasSize(1);
	}
}
