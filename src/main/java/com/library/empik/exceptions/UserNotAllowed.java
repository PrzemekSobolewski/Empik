package com.library.empik.exceptions;

import com.library.empik.serviceUtils.ExceptionReason;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = ExceptionReason.UserNotAllowed)
public class UserNotAllowed extends Exception {
    public UserNotAllowed() {
        super("Error");
    }

    public UserNotAllowed(String massage){
        super(massage);
    }
}
