package dev.dharam.orderservice.clients.productservice.dtos;

import dev.dharam.orderservice.entities.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;

    public static OrderItem from(CartItemDto cartItemDto){
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(cartItemDto.getQuantity());
        orderItem.setProductName(cartItemDto.getProductName());
        orderItem.setTotalPrice(cartItemDto.getPrice());
        orderItem.setProductId(cartItemDto.getProductId());
        return orderItem;

    }
}
