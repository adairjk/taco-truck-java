package tacoTruck.controller.advice;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity notFoundExceptionHandler() {
        return ResponseEntity.notFound().build();
    }

}
