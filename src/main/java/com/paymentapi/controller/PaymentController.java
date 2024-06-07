package com.paymentapi.controller;

import com.paymentapi.model.MembershipType;
import com.paymentapi.service.MembershipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    MembershipTypeService membershipTypeService;
    @GetMapping
    public ResponseEntity<Optional<List<MembershipType>>> showAllMembershipsType() {
        return ResponseEntity.status(200).body(Optional.ofNullable(membershipTypeService.getMembershipTypesList()));
    }

}

