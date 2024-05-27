package org.eyupcompany.invoicesmanage.exceptions.handler;


import org.eyupcompany.invoicesmanage.exceptions.EntityNotFoundException;
import org.eyupcompany.invoicesmanage.shared.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException entityNotFoundException){
        ErrorMessage errorMessage= ErrorMessage.builder()
                .message(entityNotFoundException.getMessage())
                .timestamp(new Date())
                .code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
