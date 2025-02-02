package spring.ejemplos.ormh2martinmigoyo.repos;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.ejemplos.ormh2martinmigoyo.entitys.WishLists;

import java.util.List;

public interface WishListsRepo extends JpaRepository<WishLists,Integer> {
    public List<WishLists> findAllByCustomerIdCustomerId(int customerId);
    @Transactional
    void deleteByWishListId(int wishlistId);

    WishLists findByWishListId(int wishlistId);
}
