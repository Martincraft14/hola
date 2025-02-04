package spring.ejemplos.ormh2martinmigoyo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.ejemplos.ormh2martinmigoyo.entitys.Shipments;

public interface ShipmentRepo extends JpaRepository<Shipments,Integer> {

}
