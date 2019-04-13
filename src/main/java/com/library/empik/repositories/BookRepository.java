package com.library.empik.repositories;

import com.library.empik.entities.Book;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book WHERE title = ?1", nativeQuery = true)
    Optional<Book> findByTitle(String title);

    @Query(value = "SELECT * FROM book WHERE author= ?1", nativeQuery = true)
    List<Book> findByAuthor(String author);

    @Query(value = "SELECT * FROM book WHERE title=?1 and author=?2", nativeQuery = true)
    List<Book> findByTitleAndAuthor(String title, String author);

    @Query(value = "SELECT * FROM book ORDER BY id", nativeQuery = true)
    List<Book> sortById();

    @Query(value = "SELECT * FROM book ORDER BY title", nativeQuery = true)
    List<Book> sortByTitle();

    @Query(value = "SELECT * FROM book ORDER BY author", nativeQuery = true)
    List<Book> sortByAuthor();

    @Query(value = "SELECT * FROM book ORDER BY prize", nativeQuery = true)
    List<Book> sortByPrizeAscending();

    @Query(value = "SELECT * FROM book ORDER BY prize DESC ", nativeQuery = true)
    List<Book> sortByPrizeDescending();





}
