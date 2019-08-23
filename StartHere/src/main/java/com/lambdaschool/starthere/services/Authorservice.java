package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;

import java.util.List;

public interface Authorservice {

    List<Author> findAll();

    Author findById(long id);

    void delete(long id);

    Author save(Author author);

//    Author update(Author author, long id);
}
