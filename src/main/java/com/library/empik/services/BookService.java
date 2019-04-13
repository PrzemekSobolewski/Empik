package com.library.empik.services;

import com.library.empik.dto.BookDTO;
import com.library.empik.entities.Book;
import com.library.empik.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.library.empik.dto.SubBookDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBooksById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book addBook(BookDTO dto) {
        Book book = new Book();
        book.setAuthor(dto.getAuthor());
        book.setPrize(dto.getPrize());
        book.setTitle(dto.getTitle());

        return bookRepository.save(book);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> deleteBooksById(Long id) {
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }

    public List<Book> getBooksByTitleAndAuthor(String title, String author) {
        return bookRepository.findByTitleAndAuthor(title, author);
    }

    @Transactional
    public Book changeBooksById(SubBookDTO dto) {
        Book book = bookRepository.getOne(dto.getId());
        book.setId(dto.getId());
        book.setAuthor(dto.getAuthor());
        book.setPrize(dto.getPrize());
        book.setTitle(dto.getTitle());
        return book;

    }

    public List<Book> sortBooksById() {
        return bookRepository.sortById();
    }

    public List<Book> sortBooksByTitle() {
        return bookRepository.sortByTitle();
    }

    public List<Book> sortBooksByAuthor(){
        return bookRepository.sortByAuthor();
    }

    public List<Book> sortBooksByPrizeAscending(){
        return bookRepository.sortByPrizeAscending();
    }

    public List<Book> sortBooksByPrizeDescending(){
        return bookRepository.sortByPrizeDescending();
    }



}
