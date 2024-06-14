package dev.dharam.orderservice.services;

import dev.dharam.orderservice.clients.productservice.ProductServiceClient;
import dev.dharam.orderservice.clients.productservice.dtos.CartDto;
import dev.dharam.orderservice.clients.productservice.dtos.CartItemDto;
import dev.dharam.orderservice.dtos.CreateOrderRequestDto;
import dev.dharam.orderservice.dtos.CreateOrderResponseDto;
import dev.dharam.orderservice.dtos.GetOrderResponseDto;
import dev.dharam.orderservice.dtos.OrderItemDto;
import dev.dharam.orderservice.entities.Order;
import dev.dharam.orderservice.entities.OrderItem;
import dev.dharam.orderservice.entities.OrderStatus;
import dev.dharam.orderservice.exceptions.CartEmptyException;
import dev.dharam.orderservice.exceptions.OrderNotFoundException;
import dev.dharam.orderservice.repositories.OrderItemRepository;
import dev.dharam.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceServiceImpl implements OrderService{
    @Autowired
    private ProductServiceClient productServiceClient;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public CreateOrderResponseDto createOrder(CreateOrderRequestDto request) {

        CartDto cartDto = productServiceClient.getCartDetails(request.getUserId());
        if(cartDto.getCartItemDtoList().isEmpty()){
            throw new CartEmptyException("Cart is empty!");
        }

        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setOrderDate(Instant.now());
        List<OrderItem> orderItems = new ArrayList<>();
        long totalAmount = 0L;
        for(CartItemDto cartItemDto : cartDto.getCartItemDtoList()){
            OrderItem orderItem= CartItemDto.from(cartItemDto);
            orderItemRepository.save(orderItem);
            orderItems.add(orderItem);
            totalAmount += (long) (orderItem.getTotalPrice());
        }
        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);
        order.setStatus(OrderStatus.PENDING);
        Order savedOrder = orderRepository.save(order);

        CreateOrderResponseDto response = new CreateOrderResponseDto();
        response.setOrderId(savedOrder.getId());

        return response;
    }

    @Override
    public GetOrderResponseDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                ()-> new OrderNotFoundException("Order not foud!!")
        );

        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        for(OrderItem item : order.getOrderItems()){
            orderItemDtos.add(OrderItemDto.from(item));
        }

        GetOrderResponseDto response = new GetOrderResponseDto();
        response.setOrderItemDtos(orderItemDtos);
        response.setTotalPrice(order.getTotalAmount());
        
        return response;
    }
}
