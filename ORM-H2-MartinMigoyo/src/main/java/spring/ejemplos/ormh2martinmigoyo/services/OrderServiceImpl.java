package spring.ejemplos.ormh2martinmigoyo.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spring.ejemplos.ormh2martinmigoyo.entitys.*;
import spring.ejemplos.ormh2martinmigoyo.repos.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrdersRepo ordersRepo;
    private CustomerRepo customerRepo;
    private CartItemRepo cartItemRepo;
    private OrderItemsRepo orderItemRepository;
    private ProductRepo productRepository;
    public OrderServiceImpl(OrdersRepo ordersRepo, CustomerRepo customerRepo, CartItemRepo cartItemRepo, OrderItemsRepo orderItemRepository, ProductRepo productRepository) {
        this.ordersRepo = ordersRepo;
        this.customerRepo = customerRepo;
        this.cartItemRepo = cartItemRepo;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;

    }

    @Override
    @Transactional
    public Orders createOrder(int customerId) {
        Optional<Customers> customersOptional = customerRepo.findById(customerId);
        if (!customersOptional.isPresent()) {
            return null;
        } else {
            Customers customer = customersOptional.get();
            List<CartItems> cartItems = cartItemRepo.findByCustomerId(customersOptional.get());
            if (cartItems.isEmpty()) {
                throw new RuntimeException("El carrito está vacío");
            }
            for (CartItems cartItem : cartItems) {
                Products product = cartItem.getProductId();
                if (product.getStock() < cartItem.getQuantity()) {
                    throw new RuntimeException("No hay suficiente stock para el producto: " + product.getName());
                }
            }
            Orders order = new Orders();
            order.setCustomerId(customer);
            order.setOrderDate(LocalDateTime.now());
            order.setOrderTotal(calculateOrderTotal(cartItems));
            ordersRepo.save(order);

            for (CartItems cartItem : cartItems) {
                Products product = cartItem.getProductId();

                OrderItems orderItem = new OrderItems();
                orderItem.setOrderId(order);
                orderItem.setProduct(product);
                orderItem.setQuantity(cartItem.getQuantity());
                orderItem.setUnitPrice(product.getPrice());
                orderItemRepository.save(orderItem);

                product.setStock(product.getStock() - cartItem.getQuantity());
                productRepository.save(product);
            }
            cartItemRepo.deleteAll(cartItems);
            return order;

        }

    }

    private Double calculateOrderTotal(List<CartItems> cartItems) {
        double total = 0;
        for(CartItems cartItem : cartItems){
            total = total + (cartItem.getQuantity() * cartItem.getProductId().getPrice());
        }
        return total;
    }
}
