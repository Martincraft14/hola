package spring.ejemplos.ormh2martinmigoyo.repos;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.ejemplos.ormh2martinmigoyo.entitys.CartItems;
import spring.ejemplos.ormh2martinmigoyo.entitys.Customers;
import spring.ejemplos.ormh2martinmigoyo.entitys.Products;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItems,Integer> {
    List<CartItems> findAllByCustomerIdCustomerId(int customerId);
    @Transactional
    void deleteCartItemsByProductId(Products productId);
    List<CartItems> findByCustomerId(Customers customerId);
}
