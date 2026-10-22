package com.example.employeecrud.common;

import com.example.employeecrud.candidateexp.ResourceNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/** Every error is returned as { "message": "..." } because the Angular app reads err.error.message. */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> notFound(ResourceNotFoundException ex) {
        return body(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String, Object>> conflict(ConflictException ex) {
        return body(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> badRequest(IllegalArgumentException ex) {
        return body(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> integrity(DataIntegrityViolationException ex) {
        return body(HttpStatus.CONFLICT, "This record conflicts with existing data (duplicate or linked records).");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> unreadable(HttpMessageNotReadableException ex) {
        return body(HttpStatus.BAD_REQUEST, "The request body is malformed or has a wrong value (check dates and numbers).");
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Map<String, Object>> tooLarge(MaxUploadSizeExceededException ex) {
        return body(HttpStatus.PAYLOAD_TOO_LARGE, "File is too large (max 10 MB).");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> invalid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> errors.putIfAbsent(e.getField(), e.getDefaultMessage()));
        Map<String, Object> b = new LinkedHashMap<>();
        b.put("message", errors.isEmpty() ? "Please correct the highlighted fields"
                : "Please correct the highlighted fields: " + String.join("; ", errors.values()));
        b.put("errors", errors);
        return ResponseEntity.badRequest().body(b);
    }

    private ResponseEntity<Map<String, Object>> body(HttpStatus status, String msg) {
        Map<String, Object> b = new LinkedHashMap<>();
        b.put("message", msg);
        return ResponseEntity.status(status).body(b);
    }
}
