package yte.intern.spring_web.globalExceptionHandling;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public List<String> exception(MethodArgumentNotValidException e) {
        return e.getFieldErrors()
                .stream()
                .map(ex -> ex.getDefaultMessage())
                .toList();
    }
}
