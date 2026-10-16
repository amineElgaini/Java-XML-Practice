package com.amine;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.util.ArrayList;

public class WriteApp {
    public static void main(String[] args) throws Exception {
        Book b1 = new Book();
        b1.id = "3";
        b1.title = "Head First Java";
        b1.author = "Kathy Sierra";

        Book b2 = new Book();
        b2.id = "4";
        b2.title = "Java Concurrency in Practice";
        b2.author = "Brian Goetz";

        Library library = new Library();
        library.books = new ArrayList<>();
        library.books.add(b1);
        library.books.add(b2);

        XmlMapper mapper = new XmlMapper();
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File("output.xml"), library);

        System.out.println("File created: output.xml");
    }
}
