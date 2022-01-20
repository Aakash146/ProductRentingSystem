package com.story.Renting.Service;

import com.story.Renting.DTO.BookDTO;
import com.story.Renting.DTO.BookDetailDTO;
import com.story.Renting.Entity.Book;

import java.util.List;

public interface IBookService {
    List<BookDetailDTO> getAllBooksDetail();

    Book addNewBook(BookDTO bookDTO);

    Book updatePriceOfBook(Long bookkId, BookDTO bookDTO);

    String deleteBook(Long farmId);
}
