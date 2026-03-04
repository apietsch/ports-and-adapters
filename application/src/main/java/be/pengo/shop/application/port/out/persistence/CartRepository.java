package be.pengo.shop.application.port.out.persistence;

import be.pengo.shop.model.cart.Cart;
import be.pengo.shop.model.customer.CustomerId;

import java.util.Optional;

public interface CartRepository {
    void save(Cart cart);

    Optional<Cart> findByCustomerId(CustomerId id);
}
