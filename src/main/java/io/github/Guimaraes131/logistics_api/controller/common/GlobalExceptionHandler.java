package io.github.Guimaraes131.logistics_api.controller.common;

import io.github.Guimaraes131.logistics_api.controller.dto.ErrorResponse;
import io.github.Guimaraes131.logistics_api.controller.dto.FieldError;
import io.github.Guimaraes131.logistics_api.exception.DuplicateRecordException;
import io.github.Guimaraes131.logistics_api.exception.InvalidStatusException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(DuplicateRecordException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleDuplicateRecordException(DuplicateRecordException e) {
        return ErrorResponse.conflictResponse(e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException e) {
        return ErrorResponse.notFoundResponse(e.getMessage());
    }

    @ExceptionHandler(InvalidStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidStatusException(InvalidStatusException e) {
        return ErrorResponse.badRequestResponse(e.getMessage());
    }
}
