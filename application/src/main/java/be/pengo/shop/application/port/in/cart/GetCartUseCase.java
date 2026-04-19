package be.pengo.shop.application.port.in.cart;

import be.pengo.shop.model.cart.Cart;
import be.pengo.shop.model.customer.CustomerId;

public interface GetCartUseCase {

    Cart getCart(CustomerId customerId);
}
