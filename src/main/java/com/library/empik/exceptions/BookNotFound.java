package com.library.empik.exceptions;

import com.library.empik.serviceUtils.ExceptionReason;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = ExceptionReason.BookNotFound)
public class BookNotFound extends Exception {
    public BookNotFound(){
        super("Error");
    }

    public BookNotFound(String massage){
        super(massage);
    }

}
