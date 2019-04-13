package com.library.empik.exceptions;

import com.library.empik.serviceUtils.ExceptionReason;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = ExceptionReason.BookNotAllowed)
public class BookNotAllowed  extends Exception{

    public BookNotAllowed(){
        super("Error");
    }

    public BookNotAllowed(String massage){
        super(massage);
    }
}
