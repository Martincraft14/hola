package spring.ejemplos.ormh2martinmigoyo.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.ejemplos.ormh2martinmigoyo.dto.CartItmesDTO;
import spring.ejemplos.ormh2martinmigoyo.entitys.CartItems;
import spring.ejemplos.ormh2martinmigoyo.services.CartItemsService;

import java.util.List;

@RestController
@RequestMapping( "/api/cart")
public class CartItemController {
    private CartItemsService cartItemsService;
    public CartItemController(CartItemsService cartItemsService) {
        this.cartItemsService = cartItemsService;
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<List<CartItems>> findAllByCustomerId(@PathVariable int customerId){
        return ResponseEntity.ok(cartItemsService.find(customerId));
    }
    @PostMapping("/{customerId}")
    public ResponseEntity<?> createCartItem(@PathVariable int customerId, @RequestBody CartItmesDTO cartItmesDTO){
        try{
            cartItemsService.CreateCartItem(cartItmesDTO,customerId);
            return ResponseEntity.created(null).body("Creado");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{customerId}/{productId}")
    public ResponseEntity<?> deleteCartItem(@PathVariable int customerId, @PathVariable int productId){
        cartItemsService.deleteProduct(customerId, productId);
        return ResponseEntity.ok("Eliminado");
    }
    @PostMapping("/empty/{customerId}")
    public ResponseEntity<List<CartItmesDTO>> emptyCart(@PathVariable int customerId) {
        List<CartItmesDTO> emptyCart = cartItemsService.emptyCart(customerId);
        return ResponseEntity.ok(emptyCart);
    }



}
