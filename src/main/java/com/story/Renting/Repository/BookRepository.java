package com.story.Renting.Repository;

import com.story.Renting.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String bookName);
}
