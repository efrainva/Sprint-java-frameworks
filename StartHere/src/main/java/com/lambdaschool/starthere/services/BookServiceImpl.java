package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookrepo;


    @Override
    public List<Book> findAll(Pageable pageable) {
        List<Book> list = new ArrayList<>();
        bookrepo.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book findById(long id) {
        return bookrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id) {
        if (bookrepo.findById(id).isPresent())
        {
            bookrepo.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }


    @Transactional
    @Override
    public Book save(Book book)
    {
        Book newBook = new Book();

        newBook.setBooktittle(book.getBooktittle());
        newBook.setCopy(book.getCopy());
        newBook.setIsdn(book.getIsdn());

        return bookrepo.save(newBook);

    }

    @Transactional
    @Override
    public Book update(Book book, long id) {
        Book currentBook = bookrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (book.getBooktittle() != null) {
            currentBook.setBooktittle(book.getBooktittle());
        }

        if (book.getCopy() != 0) {
            currentBook.setCopy(book.getCopy());
        }

        if (book.getIsdn() != null) {
            currentBook.setIsdn(book.getIsdn());
        }

        return bookrepo.save(currentBook);
    }

}
