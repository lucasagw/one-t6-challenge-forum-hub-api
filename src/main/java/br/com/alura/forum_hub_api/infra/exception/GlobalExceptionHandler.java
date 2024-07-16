package br.com.alura.forum_hub_api.infra.exception;

import br.com.alura.forum_hub_api.domain.DuplicateTopicException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateTopicException.class)
    public ResponseEntity<String> handleDuplicateTopicException(DuplicateTopicException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String, Object> handleValidationNoSuchElementException(NoSuchElementException ex) {

        Map<String, Object> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        errors.put("code", HttpStatus.NOT_FOUND.value());
        return errors;
    }

}
