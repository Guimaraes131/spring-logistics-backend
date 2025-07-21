package io.github.Guimaraes131.logistics_api.controller.common;

import io.github.Guimaraes131.logistics_api.controller.dto.ErrorResponse;
import io.github.Guimaraes131.logistics_api.controller.dto.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final var fieldErrors = e.getFieldErrors();

        List<FieldError> fe = fieldErrors.stream()
                .map(FieldError::new)
                .toList();

        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Validation Error", fe);
    }
}
