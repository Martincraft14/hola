package spring.ejemplos.ormh2martinmigoyo.entitys;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class WishLists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wish_list_id")
    private Integer wishListId;
    @Column(nullable = false)
    private Boolean shared;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customerId;

    @ManyToMany(mappedBy = "wishLists")
    @JsonBackReference
    private List<Products> products;

}
