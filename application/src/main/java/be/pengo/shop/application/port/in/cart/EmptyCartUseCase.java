package be.pengo.shop.application.port.in.cart;

import be.pengo.shop.model.customer.CustomerId;

public interface EmptyCartUseCase {

    void emptyCart(CustomerId customerId);
}
