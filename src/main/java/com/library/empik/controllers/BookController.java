package com.library.empik.controllers;

import com.library.empik.dto.BookDTO;
import com.library.empik.dto.SubBookDTO;
import com.library.empik.entities.Book;
import com.library.empik.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/getBooks")
    public ResponseEntity getBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping(value = "/getBooksById")
    public ResponseEntity getBooksById(@RequestParam(value = "id") Long id){
        return bookService
                .getBooksById(id).map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.badRequest()::build);
    }

    @PostMapping(value = "/addBook")
    public ResponseEntity addBooks(@RequestBody BookDTO book){
        return ResponseEntity.ok(bookService.addBook(book));
    }



    @GetMapping(value = "/getBooksByAuthor")
    public ResponseEntity getBooksByAuthor(@RequestParam(value="author") String author){
        return ResponseEntity.ok(bookService.getBooksByAuthor(author));
    }

   @DeleteMapping(value = "/deleteBooksById")
    public ResponseEntity deleteBooksById(@RequestParam(value="id") Long id){
        return ResponseEntity.ok(bookService.deleteBooksById(id));
   }

   @GetMapping(value = "/getBooksByTitleAndAuthor")
    public ResponseEntity getBooksByTitleAndAuthor(@RequestParam(value = "title") String title,
                                                   @RequestParam(value = "author") String author){
        return ResponseEntity.ok(bookService.getBooksByTitleAndAuthor(title, author));

   }

   @PostMapping(value = "/changeBooksById")
    public ResponseEntity changeBooksById(@RequestBody SubBookDTO book){
        return ResponseEntity.ok(bookService.changeBooksById(book));
   }

   @GetMapping(value = "/sortBooksById")
    public ResponseEntity sortBooksById(){
        return ResponseEntity.ok(bookService.sortBooksById());
   }

   @GetMapping(value = "/sortBooksByTitle")
    public ResponseEntity sortBooksByTitle(){
        return ResponseEntity.ok(bookService.sortBooksByTitle());
   }

   @GetMapping(value = "/sortBooksByAuthor")
    public ResponseEntity sortBooksByAuthor(){
        return ResponseEntity.ok(bookService.sortBooksByAuthor());
   }

   @GetMapping(value = "/sortBooksByPrizeAscending")
    public ResponseEntity sortBooksByPrizeAscending(){
        return ResponseEntity.ok(bookService.sortBooksByPrizeAscending());
   }

   @GetMapping(value = "/sortBooksByPrizeDescending")
    public ResponseEntity sortBooksByPrizeDescending(){
        return ResponseEntity.ok(bookService.sortBooksByPrizeDescending());
   }


}
