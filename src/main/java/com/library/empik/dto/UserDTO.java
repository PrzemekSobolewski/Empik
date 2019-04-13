package com.library.empik.dto;

import com.library.empik.entities.Book;

import java.util.List;

public class UserDTO {
    private String name;
    private String surname;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
