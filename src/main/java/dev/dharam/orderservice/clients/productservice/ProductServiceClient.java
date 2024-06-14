package dev.dharam.orderservice.clients.productservice;

import dev.dharam.orderservice.clients.productservice.dtos.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductServiceClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;


//    public ValidateTokenResponseDto validate(List<Long> productIds){
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        ValidateTokenRequestDto requestDto = new ValidateTokenRequestDto();
//        requestDto.setToken(token);
//        requestDto.setUserId(userID);
//        ResponseEntity<ValidateTokenResponseDto> res =
//                restTemplate.postForEntity("http://localhost:8080/auth/validate",
//                        requestDto,
//                        ValidateTokenResponseDto.class);
//
//        return (res.getBody());
//    }
    public CartDto getCartDetails(Long userId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<CartDto> cartDtoResponseEntity = restTemplate.getForEntity("http://localhost:8081/cart/"+userId, CartDto.class);

        return cartDtoResponseEntity.getBody();
    }

}
