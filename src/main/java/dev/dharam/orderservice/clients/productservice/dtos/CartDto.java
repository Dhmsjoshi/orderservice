package dev.dharam.orderservice.clients.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDto {
    private Long cartId;
    private List<CartItemDto> cartItemDtoList;
}
