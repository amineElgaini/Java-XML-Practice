package com.amine;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

@JacksonXmlRootElement(localName = "library")
public class Library {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "book")
    public List<Book> books;
}