package dev.dharam.orderservice.services;

import dev.dharam.orderservice.dtos.CreateOrderRequestDto;
import dev.dharam.orderservice.dtos.CreateOrderResponseDto;
import dev.dharam.orderservice.dtos.GetOrderResponseDto;

public interface OrderService {

    CreateOrderResponseDto createOrder(CreateOrderRequestDto request);
    GetOrderResponseDto getOrderById(Long orderId);
}
