package hh.BookStore.BookStore.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookStoreController {

	 @RequestMapping(value="/hello", method=RequestMethod.GET)	
	public String bookStuff(){
		return "index"; 
	 };
}
