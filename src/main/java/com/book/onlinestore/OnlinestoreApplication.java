package com.book.onlinestore;

import com.book.onlinestore.model.Book;
import com.book.onlinestore.model.User;
import com.book.onlinestore.repository.BookRepository;
import com.book.onlinestore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlinestoreApplication {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {

		SpringApplication.run(OnlinestoreApplication.class, args);
	}
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			bookRepository.save(new Book("Eze goes to School", "genre1", "1234-345","chinue Achebe", 1991,10.0));
			bookRepository.save(new Book("My Fathers car", "genre2", "1111-0000","S.M.O Aka", 1992, 20.0));
			bookRepository.save(new Book("The humble child", "genre3", "2222-111","Akezebuma special", 1990,30.0));
			bookRepository.save(new Book("Basket mouth", "genre4", "333-222","Unugbete", 1993,40.0));
			bookRepository.save(new Book("Eze goe", "genre5", "4444-333","onluyika anoson", 1994,50.0));
			bookRepository.save(new Book("the herbalist", "genre6", "555-444","chibueze anoha", 1995,60.0));
			bookRepository.save(new Book("the hunter", "genre7", "6666-5555","uzo eweche", 1996,25.0));
			bookRepository.save(new Book("Escape to Village", "genre8", "7777-666","ibuzaka saka", 1997,35.0));
			bookRepository.save(new Book("We kill Nigeria", "genre9", "8888-7777","Tinubu buhari", 1998,5.0));
			bookRepository.save(new Book("I repair Nigeria", "genre10", "999-8888","Good luck", 1999,45.0));
			userRepository.save(new User("admin", "admin"));
		};
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
