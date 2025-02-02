package spring.ejemplos.ormh2martinmigoyo.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spring.ejemplos.ormh2martinmigoyo.dto.WishListsDTO;
import spring.ejemplos.ormh2martinmigoyo.entitys.Customers;
import spring.ejemplos.ormh2martinmigoyo.entitys.Products;
import spring.ejemplos.ormh2martinmigoyo.entitys.WishLists;
import spring.ejemplos.ormh2martinmigoyo.repos.CustomerRepo;
import spring.ejemplos.ormh2martinmigoyo.repos.WishListsRepo;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class WishListsServiceImpl implements WishListsService {
    private final WishListsRepo wishListsRepo;
    private final CustomerRepo customerRepo;

    public WishListsServiceImpl(WishListsRepo wishListsRepo, CustomerRepo customerRepo) {
        this.wishListsRepo = wishListsRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public List<WishLists> findAllByCustomerId(int customerId) {
        return wishListsRepo.findAllByCustomerIdCustomerId(customerId);
    }

    @Override
    public void deleteByWishListsId(int wishlistId) {
        wishListsRepo.deleteByWishListId(wishlistId);
    }

    @Transactional
    @Override
    public WishLists addWishList(int customerId, WishListsDTO wishListsDTO) {
        Customers customers = customerRepo.findById(customerId).get();
        WishLists wishLists = new WishLists();
        wishLists.setCustomerId(customers);
        wishLists.setName(wishListsDTO.getName());
        wishLists.setShared(wishListsDTO.getShared());

        WishLists savedWishLists = wishListsRepo.save(wishLists);
        return savedWishLists;
    }

    @Override
    public List<Products> findAllProducts(int wishlistId) {
        WishLists wishLists = wishListsRepo.findByWishListId(wishlistId);
        return wishLists.getProducts();
    }
}
