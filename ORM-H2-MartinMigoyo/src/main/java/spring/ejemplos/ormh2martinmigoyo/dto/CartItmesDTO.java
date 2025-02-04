package spring.ejemplos.ormh2martinmigoyo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItmesDTO {
    private int productId;
    private int quantity;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
