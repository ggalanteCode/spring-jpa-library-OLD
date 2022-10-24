package com.soprasteria.biblioteca.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.biblioteca.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
