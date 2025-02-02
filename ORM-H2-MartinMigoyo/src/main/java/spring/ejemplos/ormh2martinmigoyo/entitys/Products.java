package spring.ejemplos.ormh2martinmigoyo.entitys;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
           name="products_categories",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"product_id", "category_id"})}
    )
    @JsonManagedReference
    private List<Categories> categories;

    @ManyToMany
    @JoinTable(
            name="whislist_products",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "wish_lists_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"product_id", "wish_lists_id"})}

    )
    @JsonManagedReference
    private List<WishLists> wishLists;
}
