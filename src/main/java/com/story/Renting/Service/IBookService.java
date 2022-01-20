package com.story.Renting.Service;

import com.story.Renting.DTO.BookDTO;
import com.story.Renting.DTO.BookDetailDTO;

import java.util.List;

public interface IBookService {
    List<BookDetailDTO> getAllBooksDetail();

    String addNewBook(BookDTO bookDTO);

    String updatePriceOfBook(Long bookkId, BookDTO bookDTO);

    String deleteBook(Long farmId);
}
