package spring.ejemplos.ormh2martinmigoyo.services;

import spring.ejemplos.ormh2martinmigoyo.dto.CartItmesDTO;
import spring.ejemplos.ormh2martinmigoyo.entitys.CartItems;

import java.util.List;

public interface CartItemsService {
    List<CartItems> find(int customerId);

    void CreateCartItem(CartItmesDTO cartItmesDTO,int customerId);


    void deleteProduct(int customerId, int productId);

    List<CartItmesDTO> emptyCart(int customerId);
}
