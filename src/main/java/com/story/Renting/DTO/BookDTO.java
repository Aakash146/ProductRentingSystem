package com.story.Renting.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {

    @JsonProperty("book_name")
    private String bookName;

    @JsonProperty("price_per_day")
    private Integer pricePerDay;

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
}
