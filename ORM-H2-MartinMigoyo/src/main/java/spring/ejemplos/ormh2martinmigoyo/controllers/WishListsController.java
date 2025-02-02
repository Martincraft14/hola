package spring.ejemplos.ormh2martinmigoyo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.ejemplos.ormh2martinmigoyo.dto.WishListsDTO;
import spring.ejemplos.ormh2martinmigoyo.entitys.Products;
import spring.ejemplos.ormh2martinmigoyo.entitys.WishLists;
import spring.ejemplos.ormh2martinmigoyo.services.WishListsService;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishListsController {
    private final WishListsService wishListsService;
    public WishListsController(WishListsService wishListsService) {
        this.wishListsService = wishListsService;
    }

    @GetMapping("/list/{customerId}")
    public ResponseEntity<List<WishLists>> findAllByCustomerId(@PathVariable int customerId){
        return ResponseEntity.ok(wishListsService.findAllByCustomerId(customerId));
    }

    @DeleteMapping("/{wishlistId}")
    public ResponseEntity<?> delateWishLists(@PathVariable int wishlistId){
        wishListsService.deleteByWishListsId(wishlistId);
        return ResponseEntity.ok("Eliminado");
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<WishLists> updateWishLists(@PathVariable int customerId, @RequestBody WishListsDTO wishListsDTO){
        WishLists wishLists = wishListsService.addWishList(customerId, wishListsDTO);
        return ResponseEntity.ok(wishLists);
    }
    @GetMapping("/{wishlistId}")
    public ResponseEntity<List<Products>> showProducts(@PathVariable int wishlistId){
        return ResponseEntity.ok(wishListsService.findAllProducts(wishlistId));
    }
}
