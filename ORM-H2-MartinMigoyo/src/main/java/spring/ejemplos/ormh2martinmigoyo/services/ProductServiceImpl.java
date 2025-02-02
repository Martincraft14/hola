package spring.ejemplos.ormh2martinmigoyo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.ejemplos.ormh2martinmigoyo.entitys.Products;
import spring.ejemplos.ormh2martinmigoyo.repos.ProductRepo;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public List<Products> findProducts(int page, int size) {
        PageRequest pageRequest =PageRequest.of(page-1, size, Sort.by("name"));
        Page<Products> productsPage = productRepo.findAll(pageRequest);
        return productsPage.getContent();

    }

    @Override
    public List<Products> findByName(String name, int page, int size) {
        PageRequest pageRequest =PageRequest.of(page-1, size, Sort.by("name"));
        Page<Products> productsPage = productRepo.findAllByNameContainingIgnoreCaseOrderByName(name,pageRequest);
        return productsPage.getContent();
    }
}
