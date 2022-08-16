package com.example.notes.Exception.handller;

import com.example.notes.Exception.UserNotFound;
import com.example.notes.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandller {
    @ExceptionHandler(UserNotFound.class)

    public ResponseEntity<Response> handleHiringException(UserNotFound ue){
        Response response=new Response();
        response.setErrorcode(400);
        response.setMessage(ue.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
