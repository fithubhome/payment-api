//package com.paymentapi.service.external.gymwebappapi.post;
//
//import com.paymentapi.model.external.gymwebappapi.post.PaymentStatusResponse;
//import com.paymentapi.model.external.membershipapi.post.PaymentModel;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class GymWebAppApiResponse {
//    private static final String BASE_URL = "http://localhost:8080";
//    private static final String BASE_URI = "/membership/transactionSuccessful";
//    private static final RestTemplate SERVER = new RestTemplate();
//
//    public void postRequest(PaymentStatusResponse paymentStatusResponse){
//
//        SERVER.postForObject(String.format("%s%s", BASE_URL, BASE_URI),
//                paymentStatusResponse,
//                String.class);
//    }
//
//}
