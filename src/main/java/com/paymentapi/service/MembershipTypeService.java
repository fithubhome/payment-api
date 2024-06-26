package com.paymentapi.service;

import com.paymentapi.model.external.membershipapi.get.MembershipTypeExternal;
import com.paymentapi.service.external.membershipapi.get.MembershipTypeServiceClient;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Getter
public class MembershipTypeService {

    private List<MembershipTypeExternal> membershipTypesList = new ArrayList<>();

    public MembershipTypeService(MembershipTypeServiceClient membershipTypeServiceClient) {

        Optional<MembershipTypeExternal[]> optionalMembershipTypes = membershipTypeServiceClient.requestMembershipTypesExternal();

        if (optionalMembershipTypes.isPresent()) {
            Arrays.stream(optionalMembershipTypes.get()).forEach(
                    mbTypeExt -> membershipTypesList.add(
                           mbTypeExt));
        } else {
            membershipTypesList.add(
                    new MembershipTypeExternal(
                            null,
                            "This is an ERROR",
                            null));
            System.out.println("No membership types available.");
            // Add logger issue here
        }
    }
}
