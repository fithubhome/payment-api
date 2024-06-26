package com.payment.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.payment.api.model.Payment;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
