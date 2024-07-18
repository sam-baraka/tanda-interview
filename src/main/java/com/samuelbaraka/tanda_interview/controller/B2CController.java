package com.samuelbaraka.tanda_interview.controller;

import com.samuelbaraka.tanda_interview.model.B2CRequest;
import com.samuelbaraka.tanda_interview.service.B2CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/b2c")
public class B2CController {

    @Autowired
    private B2CService b2cService;

    @PostMapping
    public ResponseEntity<?> createB2CRequest(@RequestBody B2CRequest request) {
        try {
            B2CRequest createdRequest = b2cService.createB2CRequest(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid request data: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getB2CRequest(@PathVariable String id) {
        try {
            B2CRequest request = b2cService.getB2CRequest(id);
            if (request == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the request");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateB2CRequest(@PathVariable String id, @RequestParam String status) {
        try {
            B2CRequest updatedRequest = b2cService.updateB2CRequest(id, status);
            if (updatedRequest == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid status: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the request");
        }
    }
}