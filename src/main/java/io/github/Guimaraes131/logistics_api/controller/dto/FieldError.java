package io.github.Guimaraes131.logistics_api.controller.dto;

public record FieldError(String field, String error) {

    public FieldError(org.springframework.validation.FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
