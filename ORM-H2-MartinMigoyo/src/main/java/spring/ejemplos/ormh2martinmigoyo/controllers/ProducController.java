package spring.ejemplos.ormh2martinmigoyo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.ejemplos.ormh2martinmigoyo.entitys.Products;
import spring.ejemplos.ormh2martinmigoyo.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProducController {
    private final ProductService productService;
    public ProducController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{page}/{pageSize}")
    public ResponseEntity<List<Products>> findAll(@PathVariable int page, @PathVariable int pageSize){
        return ResponseEntity.ok(productService.findProducts(page,pageSize));
    }
    @GetMapping("/search/{query}/{page}/{pageSize}")
    public ResponseEntity<List<Products>> findByName(@PathVariable String query, @PathVariable int page, @PathVariable int pageSize){
        return ResponseEntity.ok(productService.findByName(query,page,pageSize));
    }
}
