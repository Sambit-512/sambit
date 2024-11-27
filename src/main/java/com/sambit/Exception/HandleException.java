package com.sambit.Exception;

import com.sambit.payload.ErrorDetiles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetiles> ResourceNotFoundException(
            ResourceNotFound e , WebRequest request
            ){

 ErrorDetiles errorDetiles= new ErrorDetiles(
          e.getMessage(),
         new Date(),
         request.getDescription(false)
 );
        return new ResponseEntity<>(errorDetiles, HttpStatus.OK);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetiles> GlobalException(
            Exception e , WebRequest request
    ){

        ErrorDetiles errorDetiles= new ErrorDetiles(
                e.getMessage(),
                new Date(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorDetiles, HttpStatus.OK);
    }

}
