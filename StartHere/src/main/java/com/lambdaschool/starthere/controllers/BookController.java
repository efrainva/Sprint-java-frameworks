package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.BookService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/authors",
            produces = {"application/json"})
    public ResponseEntity<?> listBookPageing(
            @PageableDefault(page = 0,
            size = 4)
                    Pageable pageable)
    {
        List<Book> allAuthors = bookService.findAll(pageable);
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }

    @PostMapping(value = "/authors")
    public ResponseEntity<?> addNewBook(HttpServletRequest request,
    @RequestBody
            Book newbook)
    {
        newbook = bookService.save(newbook);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{bookid}").buildAndExpand(newbook.getBookid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @PutMapping(value = "/restaurant/{restaurantid}")
    public ResponseEntity<?> updateBook(
            @RequestBody
                    Book updateBook,
            @ApiParam(value = "Book id", required = true, example = "1")
            @PathVariable
                    long boookid)
    {
        bookService.update(updateBook, boookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/restaurant/{restaurantid}")
    public ResponseEntity<?> deleteRestaurantById(
            @PathVariable
                    long restaurantid)
    {
        bookService.delete(restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
