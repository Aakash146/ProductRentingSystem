package com.story.Renting.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.story.Renting.Enum.BookStatus;


public class BookDetailDTO {

    @JsonProperty("book_id")
    private Long bookId;

    @JsonProperty("book_name")
    private String bookName;

    @JsonProperty("price_per_day")
    private Integer pricePerDay;

    @JsonProperty("status")
    private BookStatus status;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Integer pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
