package com.example.deepDive.ood.lms;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Catalog implements Search {
    private HashMap<String, List<Book>> bookTitles;
    private HashMap<String, List<Book>> bookAuthors;
    private HashMap<String, List<Book>> bookSubjects;
    private HashMap<String, List<Book>> bookPublicationDates;

    @Override
    public List<Book> searchByTitle(String title) {
        return bookTitles.get(title);
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookAuthors.get(author);
    }

    @Override
    public List<Book> searchBySubject(String subject) {
        return bookSubjects.get(subject);
    }

    @Override
    public List<Book> searchByPubDate(Date publishDate) {
        return bookPublicationDates.get(publishDate.toString());
    }
}
