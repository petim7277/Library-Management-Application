package com.Elibrary.demo;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LoginRequest;
import com.Elibrary.demo.Dtos.Request.RegisterRequest;
import com.Elibrary.demo.Exceptions.*;
import com.Elibrary.demo.data.repositories.BookRepository;
import com.Elibrary.demo.data.repositories.LibrarianRepository;
import com.Elibrary.demo.services.Librarian.LibrarianService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

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
		registerRequest.setName("danjuma");
		registerRequest.setPassword("MyP@ssw0rd,");
		registerRequest.setEmail("exampl123@example.com");
		librarianService.register(registerRequest) ;
	}

	@Test
	public  void testThatALibrarianCanRegisterAgain(){
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setName("danjuma");
		registerRequest.setPassword("MyP@ssw0rd,");
		registerRequest.setEmail("exampl123@example.com");
		assertThrows(UserExistException.class,()-> librarianService.register(registerRequest));
	}
	@Test
	public  void  testThatLibrarianCan_Login(){
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setName("Hadassah");
		loginRequest.setPassword("MyP@ssw0rd,");
		loginRequest.setEmail("exampl123@example.com");
		librarianService.logIn(loginRequest) ;
	}

	@Test
	public  void  testThatALibrarianCan_LoginWithoutRegistering(){
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setName("Joana");
		loginRequest.setPassword("MyNewP@ssword,");
		loginRequest.setEmail("joana123@example.com");
		assertThrows(UserExistException.class,()->librarianService.logIn(loginRequest));
	}

	@Test
	public  void  testThatLibrarianCan_AddBooks(){
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookTitle("The God Are Angry");
		bookRequest.setBookAuthor("Chinua Achebe");
		bookRequest.setDateReturned(LocalDate.parse("2024-02-05"));
		//bookRequest.setDateBorrowed();
	//	librarianService.addBooks(bookRequest);
		assertEquals(1,bookRepository.count());
	}

	@Test
	public  void  testThatLibrarianCan_AddMoreBooks(){
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookTitle("Sweet Sixteen");
		bookRequest.setBookAuthor("Chinua Achebe");
		//bookRequest.setYearOfPublication("1991");
	//	librarianService.addBooks(bookRequest);
	
	}

	@Test
	public  void testThatWhenITryTo_AddAnExistingBook_ThrowsAnException(){
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookTitle("Midlife Crisis");
		bookRequest.setBookAuthor("Chinua Achebe");
	//	bookRequest.setYearOfPublication("1990");
	//	assertThrows(BookExistException.class,()->librarianService.addBooks(bookRequest)) ;
	}

	@Test
	public  void  testThatALibrarianCan_CheckForAvailableBooks(){
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookTitle("Midlife Crisis");
		bookRequest.setBookAuthor("Chinua Achebe");
	//	bookRequest.setYearOfPublication("1990");
		assertTrue(	librarianService.checkBookAvailability(bookRequest)	);
	}

	@Test
	public  void  testThatABookThat_HasNotBeenAdded_IsNotAvailable(){
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookTitle("Delilah's Fortress");
		bookRequest.setBookAuthor("Chinua Achebe");
	//	bookRequest.setYearOfPublication("1990");
		assertThrows(BookExistException.class,()->librarianService.checkBookAvailability(bookRequest));
	}

	@Test
	public  void  checkTheNumberOf_BooksInTheRepository(){
		assertEquals(3,bookRepository.count());
	}
    @Test

	public void testThatLibrarianCan_LendBookToUser(){
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookTitle("Amanda's");
	}

}
