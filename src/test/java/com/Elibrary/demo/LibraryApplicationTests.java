package com.Elibrary.demo;
import com.Elibrary.demo.Dtos.Request.BookRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianLoginRequest;
import com.Elibrary.demo.Dtos.Request.LibrarianRegisterRequest;
import com.Elibrary.demo.Exceptions.BookExistException;
import com.Elibrary.demo.Exceptions.InvalidBookException;
import com.Elibrary.demo.Exceptions.InvalidDetailsException;
import com.Elibrary.demo.Exceptions.UserExistException;
import com.Elibrary.demo.data.models.Librarian;
import com.Elibrary.demo.data.repositories.BookRepository;
import com.Elibrary.demo.data.repositories.LibrarianRepository;
import com.Elibrary.demo.services.LibrarianService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LibrarianServiceImplTests {


	@Autowired
	private LibrarianService librarianService;

	@Autowired
	private LibrarianRepository librarianRepository;

	@Autowired
	private BookRepository bookRepository;

	@AfterEach
 public  void deleteRegisterInfo(){
		//librarianRepository.deleteAll();
		//bookRepository.deleteAll();
	}

	@Test
	public void testThatALibrarianCanRegisterTest(){
		LibrarianRegisterRequest registerRequest = new LibrarianRegisterRequest();
		registerRequest.setName("chisom Iyanu");
		registerRequest.setEmail("iyanu7277@gmail.com");
		registerRequest.setPassword("iyanu,1234");
		librarianService.register(registerRequest);
		assertThrows(UserExistException.class,()-> librarianService.register(registerRequest));
	}
	@Test
	public  void testThatLibrarianCan_LogInTest(){
		LibrarianLoginRequest loginRequest = new LibrarianLoginRequest();
		loginRequest.setName("chisom Iyanu");
		loginRequest.setEmail("iyanu7277@gmail.com");
		loginRequest.setPassword("iyanu,1234");
		librarianService.logIn(loginRequest);
		//assertThrows(InvalidDetailsException.class,()-> librarianService.logIn(loginRequest));

	}

	@Test
	public  void testThatLibrarianCan_LogInAgainTest(){
		LibrarianLoginRequest loginRequest = new LibrarianLoginRequest();
		loginRequest.setName("chisom Iyanu");
		loginRequest.setEmail("iyanu7277@gmail.com");
		loginRequest.setPassword("iyanu,1234");
	}

	@Test
	public void testThatANewLibrarianCanRegisterTest(){
		LibrarianRegisterRequest registerRequest = new LibrarianRegisterRequest();
		registerRequest.setName("Adebisi Folashade TEWO");
		registerRequest.setEmail("bisiTewo7077@gmail.com");
		registerRequest.setPassword("bisi,1234");
		Librarian librarian = librarianService.register(registerRequest);
		assertEquals(librarian.getLibrarianEmail(), registerRequest.getEmail());
	}

	@Test
	public  void testThatAnotherLibrarianCan_LogInTest(){
		LibrarianLoginRequest loginRequest = new LibrarianLoginRequest();
		loginRequest.setName("Adebisi Folashade TEWO");
		loginRequest.setEmail("bisiTewo7077@gmail.com");
		loginRequest.setPassword("bisi,1234");
	}
	@Test
	public  void testThatAnotherLibrarianCan_LogInWithWrong_InfoTest(){
		LibrarianLoginRequest loginRequest = new LibrarianLoginRequest();
		loginRequest.setName("Adebisi Folashade TEWOs");
		loginRequest.setEmail("adebisiTewo7077@gmail.com");
		loginRequest.setPassword("bisi,12345");
		assertThrows(InvalidDetailsException.class,()->librarianService.logIn(loginRequest)) ;
	}
	@Test
	public  void testThatALibrarian_CanAddABook(){
	 BookRequest bookRequest = new BookRequest();
	 bookRequest.setBookTitle("Amanda's Misery");
	 bookRequest.setBookAuthor("Chinua Achebe");
	 bookRequest.setYearOfPublication("2000");
	 assertThrows(BookExistException.class,()->librarianService.addBooks(bookRequest)) ;
	}

	@Test
	public  void testThatALibrarian_CanLendABook(){
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookTitle("Amanda's Misery");
		bookRequest.setBookAuthor("Chinua Achebe");
		bookRequest.setYearOfPublication("2000");
	    librarianService.lendBooks(bookRequest);
	
	}
	 @Test
	public  void testThatICan_CheckForBook_Availability(){
		BookRequest bookRequest = new BookRequest();
		 bookRequest.setBookTitle("Amanda's Misery");
		 bookRequest.setBookAuthor("Chinua Achebe");
		 bookRequest.setYearOfPublication("2000");
		 assertTrue(librarianService.checkBookAvailability(bookRequest));
	 }

	@Test
	public  void testThatICan_CheckForAnUnavailableBook_Availability(){
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookTitle("The God's Are not to be Blamed");
		bookRequest.setBookAuthor("Chimamanda Achebe");
		bookRequest.setYearOfPublication("2001");
		assertTrue(librarianService.checkBookAvailability(bookRequest));
	}




}
