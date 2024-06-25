package com.paymentapi.service;

import com.paymentapi.model.external.gymwebappapi.post.PaymentStatusResponse;
import com.paymentapi.model.external.membershipapi.post.PaymentModel;
import com.paymentapi.model.external.membershipapi.get.MembershipTypeExternal;
import com.paymentapi.model.external.paymentapi.get.PaymentDto;
import com.paymentapi.service.external.membershipapi.post.MembershipHistoryResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Getter
@Setter

public class PaymentService {

    @Autowired
    MembershipTypeService membershipTypeService;
    @Autowired
    MembershipHistoryResponse membershipHistoryResponse;


    public String validatePaymentAndReturnPage(PaymentDto paymentDto) {
        MembershipTypeExternal membershipTypeExternal = membershipTypeService.getMembershipTypesList().stream().filter(mbType -> mbType.getId().equals(paymentDto.getSelectedMembershipId())).findFirst().orElse(new MembershipTypeExternal(null, null, null));
        if (membershipTypeExternal.getPrice() != null) {
            PaymentModel paymentModel = new PaymentModel(
                    paymentDto.getProfileID(),
                    paymentDto.getSelectedMembershipId(),
                    paymentDto.getPersonName(),
                    paymentDto.getCardNr(),
                    paymentDto.getCvc(),
                    paymentDto.getCardExpirationDate(),
                    PaymentModel.PaymentStatusEnum.PAID,
                    membershipTypeExternal.getPrice(),
                    membershipTypeExternal.getName()
            );
            System.out.println(paymentModel.toString());
            membershipHistoryResponse.postRequest(paymentModel); // This will do a POST request to MembershipAPI in order for the data to be recorded in the membership history
//            PaymentStatusResponse paymentStatusResponse1 = new PaymentStatusResponse("PAID");
           return "PAID"; // This is a POST request for GymWebApp to display the Payment Has Been Made



        }

        PaymentModel paymentModel = new PaymentModel(null, null, null, null, null, null, null, null,null);
        membershipHistoryResponse.postRequest(paymentModel);
        return "ERROR";
//        return paymentModel;
    }

}
