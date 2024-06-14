package dev.dharam.orderservice.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderItem extends BaseModel{
    private Long productId;
    private String productName;
    private int quantity;
    private double totalPrice;


}
