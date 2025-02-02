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
public class Categories {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private List<Products> products;
}
