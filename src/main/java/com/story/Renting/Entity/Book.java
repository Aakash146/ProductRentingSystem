package com.story.Renting.Entity;

import com.story.Renting.Enum.BookStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize =  1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    @Column(name = "book_id")
    private long bookId;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "price_per_day", nullable = false)
    private int pricePerDay;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BookStatus status;

    public Book() {
        //Do Nothing
    }

    public Book(long bookId, String bookName, int pricePerDay, BookStatus status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object b) {
        if (this == b) return true;
        if (b == null || getClass() != b.getClass()) return false;
        Book that = (Book) b;
        return Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", status=" + status +
                '}';
    }
}
