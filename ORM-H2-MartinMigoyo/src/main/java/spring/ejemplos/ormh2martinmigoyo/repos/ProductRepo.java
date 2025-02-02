package spring.ejemplos.ormh2martinmigoyo.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.ejemplos.ormh2martinmigoyo.entitys.Products;


public interface ProductRepo extends JpaRepository<Products,Integer> {
    Page<Products> findAll(Pageable pageable);
    Page<Products> findAllByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

}
