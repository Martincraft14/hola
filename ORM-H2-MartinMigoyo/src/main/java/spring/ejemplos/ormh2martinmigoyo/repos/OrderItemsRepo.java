package spring.ejemplos.ormh2martinmigoyo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.ejemplos.ormh2martinmigoyo.entitys.OrderItems;

public interface OrderItemsRepo extends JpaRepository<OrderItems,Integer> {
}
