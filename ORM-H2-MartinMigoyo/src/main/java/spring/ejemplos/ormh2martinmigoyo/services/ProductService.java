package spring.ejemplos.ormh2martinmigoyo.services;

import spring.ejemplos.ormh2martinmigoyo.entitys.Products;

import java.util.List;

public interface ProductService {
    List<Products> findProducts(int page, int size);
    List<Products> findByName(String name, int page, int size);
}
