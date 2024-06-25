package com.paymentapi.controller;

import com.paymentapi.model.external.membershipapi.get.MembershipTypeExternal;
import com.paymentapi.model.external.paymentapi.get.PaymentDto;
import com.paymentapi.service.MembershipTypeService;
import com.paymentapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    MembershipTypeService membershipTypeService;
    @Autowired
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity<Optional<List<MembershipTypeExternal>>> showAllMembershipsType() {
        return ResponseEntity.status(200).body(Optional.ofNullable(membershipTypeService.getMembershipTypesList()));
    }

    @PostMapping
    public ResponseEntity<String> validatePayment(@RequestBody PaymentDto paymentDto) {
        String result = paymentService.validatePaymentAndReturnPage(paymentDto);
        if ("PAID".equals(result)) {
            return ResponseEntity.status(200).body(result);
        } else {
            return ResponseEntity.status(400).body(result);
        }
    }

}

