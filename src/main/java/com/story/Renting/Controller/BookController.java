package com.story.Renting.Controller;

import com.story.Renting.DTO.BookDTO;
import com.story.Renting.DTO.BookDetailDTO;
import com.story.Renting.Entity.Book;
import com.story.Renting.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<BookDetailDTO> getAllBooksDetail(){

        return bookService.getAllBooksDetail();
    }

    @PostMapping
    public Book addNewBook(@RequestBody BookDTO bookDTO){

        return bookService.addNewBook(bookDTO);
    }

    @PutMapping(path = "{bookId}")
    public Book updatePriceOfBook(@PathVariable("bookId") Long bookId,@RequestBody BookDTO bookDTO){

        return bookService.updatePriceOfBook(bookId, bookDTO);
    }

    @DeleteMapping(path = "{bookId}")
    public String deleteBook(@PathVariable("bookId") Long bookId){

        return bookService.deleteBook(bookId);
    }
}
