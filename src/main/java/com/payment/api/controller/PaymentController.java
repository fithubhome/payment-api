package com.payment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.payment.api.model.Payment;
import com.payment.api.service.PaymentService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody Payment payment, @RequestParam UUID profileId) {
        Payment savedPayment = paymentService.savePayment(payment, profileId);
        return ResponseEntity.ok(savedPayment.getStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getPaymentStatus(@RequestBody UUID id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        return payment.map(value -> ResponseEntity.ok(value.getStatus())).orElseGet(() -> ResponseEntity.status(404).body("Error"));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }
}
