package spring.ejemplos.ormh2martinmigoyo.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import spring.ejemplos.ormh2martinmigoyo.dto.CartItmesDTO;
import spring.ejemplos.ormh2martinmigoyo.entitys.CartItems;
import spring.ejemplos.ormh2martinmigoyo.entitys.Customers;
import spring.ejemplos.ormh2martinmigoyo.entitys.Products;
import spring.ejemplos.ormh2martinmigoyo.repos.CartItemRepo;
import spring.ejemplos.ormh2martinmigoyo.repos.CustomerRepo;
import spring.ejemplos.ormh2martinmigoyo.repos.ProductRepo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemsService {
    private final ProductRepo productRepo;
    private final CustomerRepo customerRepo;
    private CartItemRepo cartItemRepo;
    public CartItemServiceImpl(CartItemRepo cartItemRepo, ProductRepo productRepo, CustomerRepo customerRepo) {
        this.cartItemRepo = cartItemRepo;
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public List<CartItems> find(int customerId) {
        return cartItemRepo.findAllByCustomerIdCustomerId(customerId);
    }

    @Override
    public void CreateCartItem(CartItmesDTO cartItmesDTO,int customerId) {
        Optional<Products> productsOptional = productRepo.findById(cartItmesDTO.getProductId());
        if(productsOptional.isEmpty()){
            throw new EntityNotFoundException(String.format("No exite la tarea con id %d", cartItmesDTO.getProductId()));
        }
        Optional<Customers> customersOptional = customerRepo.findById(customerId);
        if(customersOptional.isEmpty()){
            throw new EntityNotFoundException(String.format("No exite el cliente con id %d", customerId));
        }
        CartItems newCartItem = new CartItems();

        newCartItem.setQuantity(cartItmesDTO.getQuantity());
        newCartItem.setCustomerId(customersOptional.get());
        newCartItem.setProductId(productsOptional.get());

        cartItemRepo.save(newCartItem);
    }

    @Override
    public void deleteProduct(int customerId, int productId) {
        Optional<Customers> customersOptional = customerRepo.findById(customerId);
        if(customersOptional.isEmpty()){
            throw new EntityNotFoundException(String.format("No exite el cliente con id %d", customerId));
        }
        Optional<Products> products = productRepo.findById(productId);
        if(products.isEmpty()){
            throw new EntityNotFoundException(String.format("No exite el producto con id %d", productId));
        }else{
            cartItemRepo.deleteCartItemsByProductId(products.get());
        }

    }

    @Override
    public List<CartItmesDTO> emptyCart(int customerId) {
        Optional<Customers> customersOptional = customerRepo.findById(customerId);
        List<CartItems> cartItems = cartItemRepo.findByCustomerId(customersOptional.get());

        cartItemRepo.deleteAll(cartItems);
        return Collections.emptyList();
    }


}
