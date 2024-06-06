package com.paymentapi.service.external;


import com.paymentapi.model.external.MembershipTypeExternal;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Getter
public class MembershipTypeServiceClient {

    private static final String BASE_URL = "http://localhost:8085";
    private static final String BASE_URI = "/membershipType";
    private static final RestTemplate CLIENT = new RestTemplate();


    public ResponseEntity<MembershipTypeExternal[]> response = CLIENT
            .getForEntity(
                    String.format("%s%s", BASE_URL, BASE_URI),
                    MembershipTypeExternal[].class);

    public MembershipTypeExternal[] membershipTypeExternalList = response.getBody();


}
