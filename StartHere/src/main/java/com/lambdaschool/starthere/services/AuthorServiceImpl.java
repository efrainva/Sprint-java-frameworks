package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements Authorservice{

    @Autowired
    private AuthorRepository authorRepos;

    public List<Author> findAll() {
        List<Author> list = new ArrayList<>();
        authorRepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Author findById(long id) {
        return authorRepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id)
    {
        if (authorRepos.findById(id).isPresent())
        {
            authorRepos.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Author save(Author author)
    {
        return authorRepos.save(author);
    }

//    @Transactional
//    @Override
//    public Author update (Author author,long id)
//    {
//        return authorRepos.save();
//    }

}
