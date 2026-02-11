package be.pengo.shop.model.money;

import java.util.Currency;

public class TestMoneyFactory {
  private static final Currency EUR = Currency.getInstance("EUR");

  public static Money euros(int euros, int cents) {
    return Money.of(EUR, euros, cents);
  }
}
