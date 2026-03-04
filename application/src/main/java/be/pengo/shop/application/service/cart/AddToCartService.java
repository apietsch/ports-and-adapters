package be.pengo.shop.application.service.cart;

import be.pengo.shop.application.port.in.cart.AddToCartUseCase;
import be.pengo.shop.application.port.in.cart.ProductNotFoundException;
import be.pengo.shop.application.port.out.persistence.CartRepository;
import be.pengo.shop.application.port.out.persistence.ProductRepository;
import be.pengo.shop.model.cart.Cart;
import be.pengo.shop.model.cart.NotEnoughItemsInStockException;
import be.pengo.shop.model.customer.CustomerId;
import be.pengo.shop.model.product.Product;
import be.pengo.shop.model.product.ProductId;

import java.util.Objects;

public class AddToCartService implements AddToCartUseCase {

    private final CartRepository cartRepsoitory;
    private final ProductRepository productRepository;

    public AddToCartService(CartRepository cartRepsoitory, ProductRepository productRepository) {
        this.cartRepsoitory = cartRepsoitory;
        this.productRepository = productRepository;
    }

    @Override
    public Cart addToCart(CustomerId customerId, ProductId productId, int quantity) throws ProductNotFoundException, NotEnoughItemsInStockException {
        Objects.requireNonNull(customerId, "'customerId' must not be null");
        Objects.requireNonNull(productId, "'productId' must not be null");
        if (quantity < 1) {
            throw new IllegalArgumentException("'quantity' must be greater than 0");
        }

        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

        Cart cart =  cartRepsoitory
                .findByCustomerId(customerId)
                .orElseGet(() -> new Cart(customerId));

        cart.addProduct(product, quantity);

        cartRepsoitory.save(cart);

        return cart;
    }
}
