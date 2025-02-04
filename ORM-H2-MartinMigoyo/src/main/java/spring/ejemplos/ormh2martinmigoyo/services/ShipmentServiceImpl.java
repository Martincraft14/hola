package spring.ejemplos.ormh2martinmigoyo.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spring.ejemplos.ormh2martinmigoyo.dto.ShpimentDTO;
import spring.ejemplos.ormh2martinmigoyo.entitys.Orders;
import spring.ejemplos.ormh2martinmigoyo.entitys.Shipments;
import spring.ejemplos.ormh2martinmigoyo.repos.OrdersRepo;
import spring.ejemplos.ormh2martinmigoyo.repos.ShipmentRepo;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    private ShipmentRepo shipmentRepo;
    private OrdersRepo ordersRepo;
    public ShipmentServiceImpl(ShipmentRepo shipmentRepo, OrdersRepo ordersRepo) {
        this.shipmentRepo = shipmentRepo;
        this.ordersRepo = ordersRepo;

    }


    @Override
    @Transactional
    public Shipments createShipment(Integer orderId, ShpimentDTO shipmentDTO) {
        Optional<Orders> order = ordersRepo.findById(orderId);
        if(order.isPresent()){
            Shipments shipment = new Shipments();
            shipment.setOrdersId(order.get());
            shipment.setShipmentDate(LocalDateTime.now());
            shipment.setAddress(shipmentDTO.getAddress());
            shipment.setZipCode(shipmentDTO.getZipCode());
            shipment.setCity(shipmentDTO.getCity());
            shipment.setState(shipmentDTO.getState());
            shipment.setCountry(shipmentDTO.getCountry());

            return shipmentRepo.save(shipment);
        }else {
            throw new EntityNotFoundException(String.format("no se encuentra el order con id: %s", orderId));
        }
    }
}
