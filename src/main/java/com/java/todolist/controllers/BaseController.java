package com.java.todolist.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controlador base que contiene:
 * - Ruta base común (/api/v1)
 * - Métodos utilitarios para respuestas
 * - Manejo centralizado de errores
 */
@RestController
public class BaseController {

    protected <T> ResponseEntity<T> createdResponse(T body) {
        return ResponseEntity.status(201).body(body);
    }

    protected <T> ResponseEntity<T> successResponse(T body) {
        return ResponseEntity.status(200).body(body);
    }

    protected ResponseEntity<Void> noContentResponse() {
        return ResponseEntity.noContent().build();
    }


}
