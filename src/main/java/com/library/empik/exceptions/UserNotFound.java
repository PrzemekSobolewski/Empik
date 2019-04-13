package com.library.empik.exceptions;

import com.library.empik.serviceUtils.ExceptionReason;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = ExceptionReason.UserNotFound)
public class UserNotFound extends Exception {

    public UserNotFound(){
        super("Error");
    }

    public UserNotFound(String massage){
        super(massage);
    }

}
