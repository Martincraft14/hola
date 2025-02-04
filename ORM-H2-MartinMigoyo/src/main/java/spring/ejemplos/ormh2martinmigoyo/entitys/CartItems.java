package spring.ejemplos.ormh2martinmigoyo.entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CartItems {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer carItemsID;
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Products productId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customerId;

    public Integer getCarItemsID() {
        return carItemsID;
    }

    public void setCarItemsID(Integer carItemsID) {
        this.carItemsID = carItemsID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }
}
