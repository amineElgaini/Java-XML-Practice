package com.amine;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        XmlMapper mapper = new XmlMapper();
        Library library = mapper.readValue(new File("books.xml"), Library.class);

        for (Book b : library.books) {
            System.out.println(b.id + " - " + b.title + " by " + b.author);
        }
    }
}