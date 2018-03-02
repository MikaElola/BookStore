package hh.BookStore.BookStore.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.BookStore.BookStore.domain.Book;
import hh.BookStore.BookStore.domain.BookRepository;
import hh.BookStore.BookStore.domain.CategoryRepository;

@Controller
public class BookStoreController {
	@Autowired
	private BookRepository repository; 
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String studentlist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
		
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId){
		return repository.findOne(bookId);
	}
	
	
	 @RequestMapping(value="/addbook")	
	public String addBook(Model model){
		 model.addAttribute("book", new Book());
		 model.addAttribute("categories", crepository.findAll());
		return "addbook"; 
	 }

	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public String save(Book book){
	repository.save(book);
	return "redirect:booklist";
	 
	 }
	 @PreAuthorize("hasAuthority('ADMIN')")
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	 public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	 repository.delete(bookId);
	 return "redirect:../booklist";
	 }
	 @PreAuthorize("hasAuthority('ADMIN')")
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	 public String editBook(@PathVariable("id") Long bookId, Model model) {
	 model.addAttribute("book", repository.findOne(bookId));
	 model.addAttribute("categories", crepository.findAll());
	 return "editbook";
	 }

}
