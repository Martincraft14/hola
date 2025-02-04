package spring.ejemplos.ormh2martinmigoyo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.ejemplos.ormh2martinmigoyo.entitys.Orders;

public interface OrdersRepo extends JpaRepository<Orders,Integer> {
    Orders findById(int orderId);

}
