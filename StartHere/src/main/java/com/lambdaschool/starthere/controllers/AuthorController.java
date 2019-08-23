package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.services.Authorservice;
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
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    Authorservice authorService;

    @GetMapping(value = "/authors",
            produces = {"application/json"})
    public ResponseEntity<?> listAuthors(HttpServletRequest request)
    {
        List<Author> allAuthors = authorService.findAll();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }

    @PostMapping(value = "/authors")
    public ResponseEntity<?> addNewAuthor(HttpServletRequest request,
    @RequestBody
            Author newauthor) throws URISyntaxException
    {

        newauthor = authorService.save(newauthor);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAuthorURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{authorid}").buildAndExpand(newauthor.getAuthorid()).toUri();
        responseHeaders.setLocation(newAuthorURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> deleteAuthorById(HttpServletRequest request,
                                            @PathVariable
                                                    long id)
    {

        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
