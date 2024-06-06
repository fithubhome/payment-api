package com.paymentapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter

public class MembershipType {

    private Integer id;
    private String name;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;

}
