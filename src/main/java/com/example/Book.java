
package com.example;

import javax.xml.bind.annotation.XmlRootElement;


public class Book {


    private Long bookId;
    private String name;
    private Integer year;

    public Book() {} // JAXB needs this

    public Book(String name, int year) {
        fillbook(new Long(0), name, year);
    }
    public Book(Long ID, String name, int year) {
        fillbook(ID, name, year);
    }
    public void fillbook(Long ID, String name, int year) {
        this.bookId =ID;
        this.name = name;
        this.year = year;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return "Book name - " + name + "; issue year - " +  year + "; id = " + bookId;
    }
}



