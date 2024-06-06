package com.paymentapi.service;

import com.paymentapi.model.MembershipType;
import com.paymentapi.service.external.MembershipTypeServiceClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Getter
public class MembershipTypeService {

    @Autowired
    private MembershipTypeServiceClient membershipTypeServiceClient;
    private List<MembershipType> membershipTypesList = new ArrayList<>();


    public MembershipTypeService(MembershipTypeServiceClient membershipTypeServiceClient) {
        this.membershipTypeServiceClient = membershipTypeServiceClient;
//        this.membershipTypesList = new ArrayList<>();

        Arrays.stream(membershipTypeServiceClient.getMembershipTypeExternalList())
                .forEach(mbTypeExt -> membershipTypesList.add(
                        new MembershipType(
                                mbTypeExt.getId(),
                                mbTypeExt.getName(),
                                mbTypeExt.getPrice(),
                                LocalDate.now(),
                                LocalDate.now().plusDays(30)
                        )
                ));
    }

}
