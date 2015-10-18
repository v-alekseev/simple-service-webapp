
package com.example;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Book {


    public int id;
    public String Name;
    public String Author;
    public int CreateYear;

    public Book() {} // JAXB needs this

    public Book(String name, String author, int year) {
        fillbook(0, name, author, year);
    }
    public Book(int ID, String name, String author, int year) {
        fillbook(ID, name, author, year);
    }
    public void fillbook(int ID, String name, String author, int year) {
        this.id =ID;
        this.Name = name;
        this.Author = author;
        this.CreateYear = year;
    }



}



