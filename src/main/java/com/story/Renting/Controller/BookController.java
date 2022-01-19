package com.story.Renting.Controller;

import com.story.Renting.DTO.BookDTO;
import com.story.Renting.DTO.BookDetailDTO;
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
    public String addNewBook(@RequestBody BookDTO bookDTO){

        return bookService.addNewBook(bookDTO);
    }

    @PutMapping(path = "bookId")
    public String updatePriceOfBook(@PathVariable("bookId") Long id){

        return bookService.updatePriceOfBook(id);
    }

    @DeleteMapping(path = "bookId")
    public String deleteBook(@PathVariable("bookId") Long bookId){

        return bookService.deleteBook(bookId);
    }
}
