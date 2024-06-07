package com.paymentapi.service;

import com.paymentapi.model.MembershipType;
import com.paymentapi.model.external.MembershipTypeExternal;
import com.paymentapi.service.external.MembershipTypeServiceClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Getter
public class MembershipTypeService {

    @Autowired
    private MembershipTypeServiceClient membershipTypeServiceClient;
    private List<MembershipType> membershipTypesList = new ArrayList<>();

    public MembershipTypeService(MembershipTypeServiceClient membershipTypeServiceClient) {
        this.membershipTypeServiceClient = membershipTypeServiceClient;

        Optional<MembershipTypeExternal[]> optionalMembershipTypes = membershipTypeServiceClient.requestMembershipTypesExternal();

        if (optionalMembershipTypes.isPresent()) {
            Arrays.stream(optionalMembershipTypes.get()).forEach(
                    mbTypeExt -> membershipTypesList.add(
                            new MembershipType(
                                    mbTypeExt.getId(),
                                    mbTypeExt.getName(),
                                    mbTypeExt.getPrice(),
                                    LocalDate.now(),
                                    LocalDate.now().plusDays(30)
                            )
                    )
            );
        } else {
            membershipTypesList.add(
                    new MembershipType(
                            null,
                            "This is an ERROR",
                            null,
                            null,
                            null
                    ));
            System.out.println("No membership types available.");
            // Add logger issue here
        }
    }
}
