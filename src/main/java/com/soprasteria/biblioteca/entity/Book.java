package com.soprasteria.biblioteca.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "title must be not null")
	@Size(max = 100, message = "ISBN must be not null")
	private String title;
	
	@NotNull
	@Size(min = 13, max = 13, message = "ISBN must be 13 chars long")
	private String isbn;
	
	@NotNull(message = "the price cannot be null")
	@Positive(message = "the price must be greater than or equal to 0")
	private BigDecimal price;
	
	@NotNull(message = "the publisher cannot be null")
	private String publisher;
	
	@NotNull(message = "the genres string cannot be null")
	private String genres;
	
	@NotNull(message = "the available copies must be not null")
	@Positive(message = "the available copies must be greater than or equal to 0")
	private Integer availableCopies;
	
	@ManyToMany(mappedBy = "books")
	@JsonManagedReference
	private List<Author> authors;
	
	@OneToMany(mappedBy = "book")
	private List<Borrowing> borrowings;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
