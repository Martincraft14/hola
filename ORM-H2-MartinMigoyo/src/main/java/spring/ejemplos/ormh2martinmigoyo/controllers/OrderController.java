package spring.ejemplos.ormh2martinmigoyo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.ejemplos.ormh2martinmigoyo.dto.ShpimentDTO;
import spring.ejemplos.ormh2martinmigoyo.entitys.Orders;
import spring.ejemplos.ormh2martinmigoyo.entitys.Shipments;
import spring.ejemplos.ormh2martinmigoyo.services.OrderService;
import spring.ejemplos.ormh2martinmigoyo.services.OrderServiceImpl;
import spring.ejemplos.ormh2martinmigoyo.services.ShipmentService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShipmentService shipmentService;
    public OrderController(OrderService orderService, ShipmentService shipmentService) {
        this.orderService = orderService;
        this.shipmentService = shipmentService;
    }
    @PostMapping("/create/{customerId}")
    public ResponseEntity<Orders> createOrder(@PathVariable int customerId) {
        Orders order = orderService.createOrder(customerId);
        return ResponseEntity.ok(order);
    }
    @PostMapping("/send/{orderId}")
    public ResponseEntity<Shipments> sendOrder(@PathVariable Integer orderId, @RequestBody ShpimentDTO shipmentDTO) {
        Shipments shipment = shipmentService.createShipment(orderId, shipmentDTO);
        return ResponseEntity.ok(shipment);
    }

}
