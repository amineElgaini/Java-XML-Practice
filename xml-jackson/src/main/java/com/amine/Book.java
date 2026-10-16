package com.amine;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Book {
    @JacksonXmlProperty(isAttribute = true)
    public String id;

    public String title;
    public String author;
}
