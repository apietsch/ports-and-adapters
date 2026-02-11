package be.pengo.shop.model.money;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

  @Test
  void of() {
  }

  @Test
  void add_values_with_same_currency_success() {
    assertThat(new Money(Currency.getInstance("EUR"), BigDecimal.ONE)
            .add(new Money(Currency.getInstance("EUR"), BigDecimal.ONE))
            .amount())
            .isEqualTo(BigDecimal.TWO);
  }

  @Test
  void add_values_with_different_currency_fail() {
    assertThrows(IllegalArgumentException.class, () -> new Money(Currency.getInstance("EUR"), BigDecimal.ONE)
            .add(new Money(Currency.getInstance("BAM"), BigDecimal.ONE)));
  }

  @Test
  void multiply() {
  }

  @Test
  void currency() {
  }

  @Test
  void amount() {
  }
}