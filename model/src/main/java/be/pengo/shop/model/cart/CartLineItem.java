package be.pengo.shop.model.cart;

import be.pengo.shop.model.money.Money;
import be.pengo.shop.model.product.Product;

import java.util.Objects;

/**
 * Here we have implemented business logic for a shopping cart line item with
 * a product and quantity., namely increasing the quantity
 * of a product in the shopping cart, within a model class. This is called a
 * “Rich Domain Model” – in contrast to an “Anemic Domain Model,” where the
 * model classes contain only fields, getters, and setters, and the business
 * logic is implemented in service classes.
 */
public final class CartLineItem {

  private final Product product;
  private int quantity;


  public CartLineItem(Product product) {
    this.product = product;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void increaseQuantityBy(int augend, int itemsInStock)
          throws NotEnoughItemsInStockException {
    if (augend < 1) {
      throw new IllegalArgumentException("Quantity must be greater than 0.");
    }

    int newQuantity = quantity + augend;
    if (itemsInStock < newQuantity) {
      throw new NotEnoughItemsInStockException(("Product %s has less items in stock (%d) " +
              "than the requested total quantity (%d)")
              .formatted(product.getId(), product.getItemsInStock(), newQuantity),
              product.getItemsInStock());
    }

    this.quantity = newQuantity;
  }

  public Money subTotal() {
    return product.getPrice().multiply(quantity);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    CartLineItem that = (CartLineItem) o;
    return quantity == that.quantity && Objects.equals(product, that.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, quantity);
  }

  @Override
  public String toString() {
    return "CartLineItem{" +
            "product=" + product +
            ", quantity=" + quantity +
            '}';
  }
}
