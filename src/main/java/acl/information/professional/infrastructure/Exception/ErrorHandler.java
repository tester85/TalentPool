package acl.information.professional.infrastructure.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementExceptionsHandler(Exception ex, WebRequest request){
        return new ResponseEntity<>("Professional no ha sido encontrado", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globalExceptionsHandler(Exception ex, WebRequest request){
        log.error("globalExceptionsHandler {}", ex.getMessage());
        return new ResponseEntity<>("Error ocurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
