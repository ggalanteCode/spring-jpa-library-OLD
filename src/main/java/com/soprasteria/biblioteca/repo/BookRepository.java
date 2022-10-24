package com.soprasteria.biblioteca.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.biblioteca.entity.Author;
import com.soprasteria.biblioteca.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	
	public List<Book> findAllByAuthorsOrderByTitleAsc(Author author);

}
