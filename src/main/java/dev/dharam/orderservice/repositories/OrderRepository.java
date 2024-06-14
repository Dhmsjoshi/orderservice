package dev.dharam.orderservice.repositories;

import dev.dharam.orderservice.entities.Order;
import dev.dharam.orderservice.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
