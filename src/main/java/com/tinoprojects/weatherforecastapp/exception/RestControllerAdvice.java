package com.tinoprojects.weatherforecastapp.exception;

import com.tinoprojects.weatherforecastapp.domain.HttpResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice implements ErrorController {

    private static final String INTERNAL_ERROR_MSG = "Internal Server Error";
    private static final String RESOURCE_NOT_FOUND = "Resource Not Found: ";

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<HttpResponse> clientErrorException(HttpClientErrorException ex) {
        return new ResponseEntity<>(
                new HttpResponse(
                        ex.getRawStatusCode(),
                        ex.getStatusCode(),
                        ex.getMessage().toUpperCase(),
                        ex.getMessage()),
                ex.getStatusCode());

    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HttpResponse> resourceNotFoundException() {
        return createHttpResponse(NOT_FOUND, RESOURCE_NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> internalServerErrorException() {
        return createHttpResponse(INTERNAL_SERVER_ERROR, INTERNAL_ERROR_MSG);
    }

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus);
    }

}
