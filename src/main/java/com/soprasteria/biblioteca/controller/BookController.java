package com.soprasteria.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.biblioteca.entity.Author;
import com.soprasteria.biblioteca.entity.Book;
import com.soprasteria.biblioteca.repo.AuthorRepository;
import com.soprasteria.biblioteca.repo.BookRepository;

@RestController
@RequestMapping("/libri")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping("/booksByAuthor/{authorId}")
	public ResponseEntity<List<Book>> booksByAuthor(@PathVariable(value = "authorId") Integer authorId) {
		Optional<Author> author = authorRepository.findById(authorId);
		if(author.isPresent()) {
			return new ResponseEntity<List<Book>>(bookRepository.findAllByAuthorsOrderByTitleAsc(author.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Book>>((List<Book>)null, HttpStatus.NOT_FOUND);
		}
	}

}
