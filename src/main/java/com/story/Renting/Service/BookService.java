package com.story.Renting.Service;

import com.story.Renting.DTO.BookDTO;
import com.story.Renting.DTO.BookDetailDTO;
import com.story.Renting.Entity.Book;
import com.story.Renting.Enum.BookStatus;
import com.story.Renting.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService implements IBookService{

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;


    @Override
    @Transactional
    public Book addNewBook(BookDTO bookDTO) {
        final Book book = bookRepository.findBybookName(bookDTO.getBookName());
        if(Objects.nonNull(book)){
            LOGGER.error("Book with name: '" + bookDTO.getBookName() + "' already exists.");
            throw new IllegalStateException("Book with name: '" + bookDTO.getBookName() + "' already exists.");
//            return new ResponseEntity<>(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"bad"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        final Book newBook = new Book();
        newBook.setBookName(bookDTO.getBookName());
        newBook.setPricePerDay(bookDTO.getPricePerDay());
        newBook.setStatus(BookStatus.IN_LIBRARY);
        LOGGER.info("Book with name: '" + bookDTO.getBookName() + "' successfully added in library.");
        bookRepository.save(newBook);
        return newBook;
    }

    @Override
    @Transactional
    public Book updatePriceOfBook(Long bookId, BookDTO bookDTO) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            LOGGER.error("Book with bookId "+ bookId + " does not exists.");
            throw new IllegalStateException("Book with bookId "+ bookId + " does not exists.");
        }
        final Book book = bookRepository.findBybookId(bookId);
        Integer oldPrice = book.getPricePerDay();
        book.setPricePerDay(bookDTO.getPricePerDay());
        bookRepository.save(book);
        LOGGER.info("Price for book : '" + book.getBookName() + "' changed from " + oldPrice + " to " + book.getPricePerDay() + ".");
        return  book;

    }

    @Override
    @Transactional
    public String deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) {
            LOGGER.error("Book with bookId " + bookId + " does not exists.");
            throw new IllegalStateException("Book with bookId " + bookId + " does not exists.");
        }
        final Book book = bookRepository.findBybookId(bookId);
        String bookName = book.getBookName();
        bookRepository.deleteById(bookId);
        LOGGER.info("Book with book_Name : " + bookName + " is successfully deleted.");
        return "Book with book_Name : " + bookName + " is successfully deleted.";
    }

    @Override
    @Transactional
    public List<BookDetailDTO> getAllBooksDetail() {
        final List<Book> books = bookRepository.findAll();
        final List<BookDetailDTO> dtos = new ArrayList<>();
        books.forEach(book -> {
            final BookDetailDTO dto = new BookDetailDTO();
            dto.setBookName(book.getBookName());
            dto.setBookId(book.getBookId());
            dto.setPricePerDay(book.getPricePerDay());
            dto.setStatus(book.getStatus());
            dtos.add(dto);
        });
        return dtos;
    }
}
