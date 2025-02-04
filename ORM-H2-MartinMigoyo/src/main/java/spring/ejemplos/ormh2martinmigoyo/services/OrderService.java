package spring.ejemplos.ormh2martinmigoyo.services;

import org.springframework.stereotype.Service;
import spring.ejemplos.ormh2martinmigoyo.entitys.Orders;

@Service
public interface OrderService {
    Orders createOrder(int customerId);
}
