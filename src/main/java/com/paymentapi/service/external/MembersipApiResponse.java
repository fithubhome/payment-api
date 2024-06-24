package com.paymentapi.service.external;

import com.paymentapi.model.PaymentModel;
import com.paymentapi.model.external.PaymentDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MembersipApiResponse {

    private static final String BASE_URL = "http://localhost:8105";
    private static final String BASE_URI = "/addpayment";
    private static final RestTemplate SERVER = new RestTemplate();

    public void postRequest(PaymentModel paymentModel){
        SERVER.postForObject(String.format("%s%s", BASE_URL, BASE_URI),
                paymentModel,
                String.class);
    }

}
