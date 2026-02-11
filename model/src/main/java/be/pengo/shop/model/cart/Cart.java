package be.pengo.shop.model.cart;

import be.pengo.shop.model.customer.CustomerId;
import be.pengo.shop.model.money.Money;
import be.pengo.shop.model.product.Product;
import be.pengo.shop.model.product.ProductId;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {

  private final CustomerId customerId;
  private final Map<ProductId, CartLineItem> lineItems = new LinkedHashMap<>();

  public Cart(CustomerId customerId) {
    this.customerId = customerId;
  }

  public void addProduct(Product product, int quantity) throws NotEnoughItemsInStockException {
    lineItems
            .computeIfAbsent(product.getId(), _ -> new CartLineItem(product))
            .increaseQuantityBy(quantity, product.getItemsInStock());
  }

  public List<CartLineItem> getLineItems() {
    return List.copyOf(lineItems.values());
  }

  public int numberOfItems() {
    return lineItems.values().stream().mapToInt(CartLineItem::getQuantity).sum();
  }

  public Money subTotal() {
    return lineItems.values().stream()
            .map(CartLineItem::subTotal)
            .reduce(Money::add)
            .orElse(null); // todo: to avoid null maybe `reduce(Money.zero(), Money::add)`?
  }

  public CustomerId getCustomerId() {
    return customerId;
  }
}
