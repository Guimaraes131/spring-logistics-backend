package io.github.Guimaraes131.logistics_api.controller.dto;

import java.util.List;

public record ErrorResponse(Integer status, String message, List<FieldError> errors) {
}
