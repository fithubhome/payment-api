package com.paymentapi.service.external;

import com.paymentapi.model.PaymentModel;
import com.paymentapi.model.external.MembershipTypeExternal;
import com.paymentapi.model.external.PaymentDto;
import com.paymentapi.service.MembershipTypeService;
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
                    PaymentDto.PaymentStatusEnum.PAID,
                    membershipTypeExternal.getPrice()
            );
            return paymentModel;
        }

        return new PaymentModel(null, null, null, null, null, null, null, null);
    }


}
