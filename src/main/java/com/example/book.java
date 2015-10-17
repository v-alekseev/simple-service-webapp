package com.example;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Vitalik on 17.10.2015.
 */


@XmlRootElement
public class book {


    public String name;
    public String author;
    public int create_year;

    public book() {} // JAXB needs this

    public book(String name,String author, int year) {
        this.name = name;
        this.author = author;
        this.create_year = year;
    }
}



