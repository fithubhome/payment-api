package com.payment.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payment.api.model.Payment;
import com.payment.api.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment, UUID profileId) {
        payment.setProfileId(profileId);
        if (payment.getPrice() > 0 && payment.getName() != null && !payment.getName().isEmpty()) {
            payment.setStatus("Paid");
            return paymentRepository.save(payment);
        } else {
            payment.setStatus("Rejected");
            return payment;
        }
    }

    public Optional<Payment> getPaymentById(UUID id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
