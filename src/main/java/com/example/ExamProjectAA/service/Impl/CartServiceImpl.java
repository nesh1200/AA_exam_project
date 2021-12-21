package com.example.ExamProjectAA.service.Impl;

import com.example.ExamProjectAA.exception.ResourceNotFoundException;
import com.example.ExamProjectAA.model.Cart;
import com.example.ExamProjectAA.model.Product;
import com.example.ExamProjectAA.model.User;
import com.example.ExamProjectAA.repository.CartRepository;
import com.example.ExamProjectAA.service.CartService;
import com.example.ExamProjectAA.service.ProductService;
import com.example.ExamProjectAA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserService userService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public Cart save(Cart cart) {
        User foundUser = userService.findById(cart.getUser().getId());
        Set<Product> products = new HashSet<>();
        for(Product product: cart.getProducts()){
            Product foundProduct = productService.findById(product.getId());
            products.add(foundProduct);
        }
        return Cart.builder()
                .user(foundUser)
                .products(products)
                .is_empty(products.isEmpty())
                .build();
    }

    @Override
    public Cart findById(Long id) {
        return cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format("Make ti, nemavo idto  %d", id)));
    }

    @Override
    public Cart update(Cart cart, Long id) {
        Cart foundCart = findById(id);
        Cart toUpdate  = Cart.builder()
                .id(foundCart.getId())
                .user(cart.getUser())
                .is_empty(cart.getIs_empty())
                .products(cart.getProducts())
                .build();
        return save(toUpdate);
    }

    @Override
    public Set<Cart> findAll() {
        return new HashSet<>(cartRepository.findAll());
    }

    @Override
    public Cart clear(Long cart_id, Long user_id) {
        User foundUser = userService.findById(user_id);
        Cart foundCart = findById(cart_id);
        Cart toUpdate  = Cart.builder()
                .id(foundCart.getId())
                .user(foundUser)
                .is_empty(true)
                .products(Collections.emptySet())
                .build();
        return save(toUpdate);
    }

}
