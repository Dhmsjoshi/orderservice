package dev.dharam.orderservice.dtos;

import dev.dharam.orderservice.clients.productservice.dtos.CartItemDto;
import dev.dharam.orderservice.entities.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    private String itemName;
    private int quantity;
    private double price;

    public static OrderItemDto from(OrderItem orderItem){
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setItemName(orderItem.getProductName());
        orderItemDto.setPrice(orderItem.getTotalPrice());
        return orderItemDto;

    }
}
