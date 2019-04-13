package com.library.empik.controllers;

import com.library.empik.dto.UserDTO;
import com.library.empik.entities.Book;
import com.library.empik.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ResourceBundle;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUsers")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(value = "/getUsersById")
    public ResponseEntity getUsersById(@RequestParam(value = "id") Long id) {
        return userService
                .getUsersById(id).map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.badRequest()::build);

    }

    @GetMapping(value = "/getUsersByName")
    public ResponseEntity getUsersByName(@RequestParam(value = "name") String name){
        return userService
                .getUsersByName(name).map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.badRequest()::build);
    }

    @PostMapping(value = "/addUsers")
    public ResponseEntity addUsers(@RequestBody UserDTO user){
        return ResponseEntity.ok(userService.addUsers(user));
    }

    @DeleteMapping(value = "/deleteUsersById")
    public ResponseEntity deleteUsersById(@RequestParam(value = "id") Long id){
        userService.deleteUsersById(id);
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/updateUsers")
    public ResponseEntity updateUsers(@RequestParam(value = "id") Long id,
                                      @RequestParam(value = "name") String name,
                                      @RequestParam(value = "surname") String surname){
        return ResponseEntity.ok(userService.updateUsers(id,name,surname));
    }

//    @PostMapping(value="/addBookToUser")
////    public ResponseEntity addBookToUser(@RequestParam(value = "user_id") Long user_id,
////                                        @RequestParam(value = "book_id") Long book_id) {
////        return ResponseEntity.ok(userService.addBookToUser(user_id,book_id));
////
////    }
////
    @GetMapping(value="/addBookToUserById")
    public ResponseEntity addBookToUser(@RequestParam(value = "book_id") Long book_id, @RequestParam(value = "user_id") Long user_id){
        return userService.addBookToUser(book_id, user_id).map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.badRequest()::build);


    }

    @GetMapping(value = "/deleteBookFromUserById")
    public ResponseEntity deleteBookFromUser(@RequestParam(value = "book_id") Long book_id,
                                            @RequestParam(value = "user_id") Long user_id){
        return userService.deleteBookFromUserById(book_id, user_id).map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.badRequest()::build);

    }






}
