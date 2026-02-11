package be.pengo.shop.model.customer;
public record CustomerId(int value) {
  // todo: make this a UUID or create a UUIDCustomerId?
  public CustomerId {
    if (value < 1)
      throw new IllegalArgumentException("Customer id must be a positive integer");
  }
}