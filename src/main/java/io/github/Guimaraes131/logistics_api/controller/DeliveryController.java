package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController implements GenericController {

    private final DeliveryService service;
}
