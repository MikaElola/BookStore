package hh.BookStore.BookStore;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.BookStore.BookStore.domain.Book;
import hh.BookStore.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
	 log.info("pari kirjaa talteen");
	 repository.save(new Book("Cat in a Hat", "Dr.Seuss", 1950, 12345, 20.00));
	 repository.save(new Book("1984", "George Orwell", 1946, 5678, 25.00));
	
	 log.info("hae kaikki kirjat");
	 for (Book book : repository.findAll()) {
		 log.info(book.toString());
	 }
	
	};
	}
	
}
