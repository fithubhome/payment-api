package com.paymentapi.model.external.membershipapi;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class MembershipTypeExternal {
    private UUID id;
    private String name;
    private Double price;

}
