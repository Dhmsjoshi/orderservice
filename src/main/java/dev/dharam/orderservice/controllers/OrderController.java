package dev.dharam.orderservice.controllers;

import dev.dharam.orderservice.dtos.CreateOrderRequestDto;
import dev.dharam.orderservice.dtos.CreateOrderResponseDto;
import dev.dharam.orderservice.dtos.GetOrderResponseDto;
import dev.dharam.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<CreateOrderResponseDto> createOrder(@RequestBody CreateOrderRequestDto request){
        CreateOrderResponseDto response = orderService.createOrder(request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOrderResponseDto> getOrderById(@PathVariable("id") long orderId){
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
