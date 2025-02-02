package spring.ejemplos.ormh2martinmigoyo.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(nullable = false)
    private Double orderTotal;
    @Column(nullable = false)
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customerId;
}
