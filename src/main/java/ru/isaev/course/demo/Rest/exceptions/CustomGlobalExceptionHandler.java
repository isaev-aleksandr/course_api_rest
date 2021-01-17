package ru.isaev.course.demo.Rest.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsIncorrectCurrency.class)
    protected ResponseEntity<AwesomeException> handleThereIsNotFoundBookException() {
        return new ResponseEntity<>(new CustomGlobalExceptionHandler.AwesomeException(
                "Invalid `base` currency [FFF]. Please ensure you use the standard international code, " +
                        "and that it is supported by the API. See our documentation for details: " +
                        "https://openexchangerates.org/documentation/."), HttpStatus.NOT_FOUND);
    }

    @Data
    static class AwesomeException {

        private String message;

        public AwesomeException(String message) {
            this.message = message;
        }
    }
}