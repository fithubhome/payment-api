package com.paymentapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter

public class MembershipType {

    private UUID id;
    private String name;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;

}
