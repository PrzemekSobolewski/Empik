package com.library.empik.services;

import com.library.empik.dto.UserDTO;
import com.library.empik.entities.Book;
import com.library.empik.entities.User;
import com.library.empik.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.empik.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<User> getAllUsers(){return userRepository.findAll();}

    public Optional<User> getUsersById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> getUsersByName(String name){
        return userRepository.findByName(name);
    }

    public User addUsers(UserDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());

        return userRepository.save(user);
    }

    public void deleteUsersById(Long id){
        userRepository.deleteById(id);
    }

    public Optional<User> updateUsers(Long id, String name, String surname){
        return userRepository.updateUsers(name, surname, id);

    }

    @Transactional
    public Optional<User> addBookToUser(Long book_Id, Long user_Id){
        Optional<User> user = userRepository.findById(user_Id);
        Optional<Book> book = bookRepository.findById(book_Id);
       return user.map(u -> {
            book.ifPresent(b -> {
                u.getBooks().add(b);
            });
            return u;
        });
    }

    @Transactional
    public Optional<User> deleteBookFromUserById(Long book_id, Long user_id){
        Optional<User> user = userRepository.findById(user_id);
        Optional<Book> book = bookRepository.findById(book_id);
        return user.map(u -> {
            book.ifPresent(b ->{
                u.getBooks().remove(b);
            });
            return u;
        });


    }
//    @Transactional
//    public Optional<User> changeBookInUser(Long user_id, Long book_id, Long new_book_id){
//        Optional<User> user = userRepository.findById(user_id);
//        Optional<Book> book = bookRepository.findById(book_id);
//        Optional<Book> newBook = bookRepository.findById(new_book_id);
//
//        return user.map(u ->{
//            book.ifPresent(b -> {
//                u.getBooks().
//            });
//            newBook.ifPresent(b -> {
//                u.getBooks().add(b);
//            });
//            return u;
//        });
//
//    }





}
