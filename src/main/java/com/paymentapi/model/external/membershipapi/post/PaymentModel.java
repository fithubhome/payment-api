package com.paymentapi.model.external.membershipapi.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.YearMonth;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentModel {
    private UUID profileID;
    private UUID selectedMembershipId;
    private String personName;
    private String cardNr;
    private String cvc;
    private YearMonth cardExpirationDate;
    private PaymentStatusEnum status;
    private Double price; // This is the extra field compared to PaymentDto
    private String membershipName;
    @Override
    public String toString() {
        return "PaymentModel{" +
                "profileID=" + profileID +
                ", selectedMembershipId=" + selectedMembershipId +
                ", personName='" + personName + '\'' +
                ", cardNr='" + cardNr + '\'' +
                ", cvc='" + cvc + '\'' +
                ", cardExpirationDate=" + cardExpirationDate +
                ", status=" + status +
                ", price=" + price +
                ", membershipName='" + membershipName + '\'' +
                '}';
    }


    public enum PaymentStatusEnum {
        PENDING,
        PAID;
    }

}
