
package com.makers.searchapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ControllerAdvice
    public class GlobalExceptionHandler {

        // Handle specific exceptions
        @ExceptionHandler(ResourceNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ResponseBody
        public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex) {
            return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        }

        @ExceptionHandler(InvalidInputException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ErrorResponse handleInvalidInputException(InvalidInputException ex) {
            return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        }

        // Handle generic exceptions
        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ResponseBody
        public ErrorResponse handleGenericException(Exception ex) {
            return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred.");
        }
    }

