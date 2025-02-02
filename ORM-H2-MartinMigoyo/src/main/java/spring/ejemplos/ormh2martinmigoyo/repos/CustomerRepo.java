package spring.ejemplos.ormh2martinmigoyo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.ejemplos.ormh2martinmigoyo.entitys.Customers;

public interface CustomerRepo extends JpaRepository<Customers, Integer> {
}
