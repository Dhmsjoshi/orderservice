package dev.dharam.orderservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
public class Order extends BaseModel {
    private Instant orderDate;
    private Long userId;
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;
    private Long totalAmount;
    @OneToMany
    private List<OrderItem> orderItems;

}
