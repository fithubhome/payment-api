package com.paymentapi.service;

import com.paymentapi.model.PaymentModel;
import com.paymentapi.model.external.MembershipTypeExternal;
import com.paymentapi.model.external.PaymentDto;
import com.paymentapi.service.external.MembersipApiResponse;
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
    MembersipApiResponse membersipApiResponse;

    public PaymentModel validatePayment(PaymentDto paymentDto) {
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
            membersipApiResponse.postRequest(paymentModel);
            return paymentModel;
        }

        PaymentModel paymentModel = new PaymentModel(null, null, null, null, null, null, null, null,null);
        membersipApiResponse.postRequest(paymentModel);
        return paymentModel;
    }


}
