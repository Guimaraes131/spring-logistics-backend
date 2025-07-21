package io.github.Guimaraes131.logistics_api.controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErrorResponse(Integer status, String message, List<FieldError> errors) {

    public static ErrorResponse conflictResponse(String message) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), message, List.of());
    }

    public static ErrorResponse notFoundResponse(String message) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), message, List.of());
    }
}
