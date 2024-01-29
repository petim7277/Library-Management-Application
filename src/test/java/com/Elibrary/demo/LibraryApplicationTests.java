package com.Elibrary.demo;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.InvalidEmailException;
import com.Elibrary.demo.Exceptions.InvalidPasswordException;
import com.Elibrary.demo.Exceptions.InvalidUsernameException;
import com.Elibrary.demo.Exceptions.UserExistException;
import com.Elibrary.demo.data.repositories.BookRepository;
import com.Elibrary.demo.data.repositories.LibrarianRepository;
import com.Elibrary.demo.services.LibrarianService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LibrarianServiceTests {
	@Autowired
	private LibrarianService librarianService;

	@Autowired
	private LibrarianRepository librarianRepository;

	@Autowired
	private BookRepository bookRepository;

	@BeforeEach
 public  void deleteRegisterInfo(){
	//	librarianRepository.deleteAll();
	//	bookRepository.deleteAll();
	}
	@AfterEach
	public  void deleteInfo(){
		//librarianRepository.deleteAll();
	//	bookRepository.deleteAll();
	}

	@Test
	public  void testThatALibrarianCanRegister_WithWrongUsername(){
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setName("@precious8");
		registerRequest.setPassword("precious1234");
		registerRequest.setEmail("petim7277@gmail.com");
		assertThrows(InvalidUsernameException.class,()->librarianService.register(registerRequest)) ;
	}

	@Test
	public  void testThatALibrarianCanRegister_WithWrongPassword(){
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setName("precious");
		registerRequest.setPassword("p");
		registerRequest.setEmail("petim7277@gmail.com");
		assertThrows(InvalidPasswordException.class,()->librarianService.register(registerRequest)) ;
	}

	@Test
	public  void testThatALibrarianCanRegister_WithWrongEmail(){
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setName("precious");
		registerRequest.setPassword("precious1234");
		registerRequest.setEmail("petim7277");
		assertThrows(InvalidEmailException.class,()->librarianService.register(registerRequest)) ;
	}

	@Test
	public  void testThatALibrarianCanRegister(){
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setName("Hadassah");
		registerRequest.setPassword("MyP@ssw0rd,");
		registerRequest.setEmail("exampl123@example.com");
		librarianService.register(registerRequest) ;
	}

	@Test
	public  void testThatALibrarianCanRegisterAgain(){
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setName("Hadassah");
		registerRequest.setPassword("MyP@ssw0rd,");
		registerRequest.setEmail("exampl123@example.com");
		assertThrows(UserExistException.class,()-> librarianService.register(registerRequest));
	}




}
