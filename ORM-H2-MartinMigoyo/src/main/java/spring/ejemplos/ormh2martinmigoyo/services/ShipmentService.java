package spring.ejemplos.ormh2martinmigoyo.services;

import spring.ejemplos.ormh2martinmigoyo.dto.ShpimentDTO;
import spring.ejemplos.ormh2martinmigoyo.entitys.Shipments;

public interface ShipmentService {
    public Shipments createShipment(Integer orderId, ShpimentDTO shipmentDTO);
}
