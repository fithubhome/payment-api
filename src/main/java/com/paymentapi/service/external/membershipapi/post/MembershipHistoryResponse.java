package com.paymentapi.service.external.membershipapi.post;

import com.paymentapi.model.PaymentModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MembershipHistoryResponse {

    private static final String BASE_URL = "http://localhost:8105";
    private static final String BASE_URI = "/addpayment";
    private static final RestTemplate SERVER = new RestTemplate();

    public void postRequest(PaymentModel paymentModel){
        SERVER.postForObject(String.format("%s%s", BASE_URL, BASE_URI),
                paymentModel,
                String.class);
    }

}
