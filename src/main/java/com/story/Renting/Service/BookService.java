package com.story.Renting.Service;

import com.story.Renting.DTO.BookDTO;
import com.story.Renting.DTO.BookDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Override
    public List<BookDetailDTO> getAllBooksDetail() {
        return null;
    }

    @Override
    public String addNewBook(BookDTO bookDTO) {
        return null;
    }

    @Override
    public String updatePriceOfBook(Long id) {
        return null;
    }

    @Override
    public String deleteBook(Long farmId) {
        return null;
    }
}
