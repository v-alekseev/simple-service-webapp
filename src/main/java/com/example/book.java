package com.example;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class book {


    public String Name;
    public String Author;
    public int CreateYear;

    public book() {} // JAXB needs this

    public book(String name,String author, int year) {
        this.Name = name;
        this.Author = author;
        this.CreateYear = year;
    }


}



