package tacoTruck.controller.advice;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity handleNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity handleUnexpectedException(Throwable thr)
    {
        System.out.println(thr.getMessage());
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
