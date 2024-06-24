package com.paymentapi.model;

import com.paymentapi.model.external.PaymentDto;
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
    private PaymentDto.PaymentStatusEnum status;
    private Double price;


    public enum PaymentStatusEnum {
        PENDING,
        PAID;
    }
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
                '}';
    }
}
