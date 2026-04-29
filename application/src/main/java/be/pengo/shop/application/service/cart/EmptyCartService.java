package be.pengo.shop.application.service.cart;

import java.util.Objects;

import be.pengo.shop.application.port.in.cart.EmptyCartUseCase;
import be.pengo.shop.application.port.out.persistence.CartRepository;
import be.pengo.shop.model.customer.CustomerId;

public class EmptyCartService implements EmptyCartUseCase {

    private final CartRepository cartRepository;


    public EmptyCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    public void emptyCart(CustomerId customerId) {
        Objects.requireNonNull(customerId, "'customerId' must not be null");

        cartRepository.deleteById(customerId);
    }
    
}
