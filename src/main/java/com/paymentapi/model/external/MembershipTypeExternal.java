package com.paymentapi.model.external;


import com.paymentapi.model.MembershipType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class MembershipTypeExternal {
    private UUID id;
    private String name;
    private Double price;

}
