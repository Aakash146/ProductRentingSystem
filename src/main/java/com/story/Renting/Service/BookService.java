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
import java.util.List;
import java.util.Objects;

@Service
public class BookService implements IBookService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private BookRepository bookRepository;


    @Override
    @Transactional
    public String addNewBook(BookDTO bookDTO) {
        final Book book = bookRepository.findByName(bookDTO.getBookName());
        if(Objects.nonNull(book)){
            LOGGER.error("Book with name: '" + bookDTO.getBookName() + "' already exists.");
            throw new IllegalStateException("Book with name: '" + bookDTO.getBookName() + "' already exists.");
        }
        final Book newBook = new Book();
        newBook.setBookName(bookDTO.getBookName());
        newBook.setPricePerDay(bookDTO.getPricePerDay());
        newBook.setStatus(BookStatus.IN_LIBRARY);
        LOGGER.info("Book with name: '" + bookDTO.getBookName() + "' successfully added in library.");
        bookRepository.save(newBook);
        return "Book with name: '" + bookDTO.getBookName() + "' successfully added in library.";
    }

    @Override
    public String updatePriceOfBook(Long bookId, BookDTO bookDTO) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            LOGGER.error("Book with bookId "+ bookId + " does not exists.");
            throw new IllegalStateException("Book with bookId "+ bookId + " does not exists.");
        }
        return  "";

    }

    @Override
    public String deleteBook(Long farmId) {
        return null;
    }

    @Override
    public List<BookDetailDTO> getAllBooksDetail() {
        return null;
    }
}
