package be.pengo.shop.application.port.in.cart;

import be.pengo.shop.model.cart.Cart;
import be.pengo.shop.model.cart.NotEnoughItemsInStockException;
import be.pengo.shop.model.customer.CustomerId;
import be.pengo.shop.model.product.ProductId;

public interface AddToCartUseCase {

    Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
            throws ProductNotFoundException, NotEnoughItemsInStockException;

}
