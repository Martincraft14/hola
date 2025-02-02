package spring.ejemplos.ormh2martinmigoyo.services;

import jakarta.transaction.Transactional;
import spring.ejemplos.ormh2martinmigoyo.dto.WishListsDTO;
import spring.ejemplos.ormh2martinmigoyo.entitys.Products;
import spring.ejemplos.ormh2martinmigoyo.entitys.WishLists;

import java.beans.Transient;
import java.util.List;

public interface WishListsService {
    List<WishLists> findAllByCustomerId(int customerId);

    @Transactional
    void deleteByWishListsId(int wishlistId);

    WishLists addWishList(int customerId, WishListsDTO wishListsDTO);

    List<Products> findAllProducts(int wishlistId);
}
