package dev.dharam.orderservice.dtos;

import dev.dharam.orderservice.entities.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetOrderResponseDto {
    private List<OrderItemDto> orderItemDtos;
    private double totalPrice;
}
