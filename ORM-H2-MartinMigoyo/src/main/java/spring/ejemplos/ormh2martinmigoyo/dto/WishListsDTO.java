package spring.ejemplos.ormh2martinmigoyo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishListsDTO {
    private String name;
    private Boolean shared;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }
}
