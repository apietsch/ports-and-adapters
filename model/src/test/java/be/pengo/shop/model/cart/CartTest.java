package be.pengo.shop.model.cart;

import be.pengo.shop.model.product.Product;
import be.pengo.shop.model.product.TestProductFactory;
import org.junit.jupiter.api.Test;

import static be.pengo.shop.model.money.TestMoneyFactory.euros;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CartTest {

  @Test
  void givenEmptyCart_addTwoProducts_numberOfItemsAndSubTotalIsCalculatedCorrectly() throws NotEnoughItemsInStockException {
    Cart cart = TestCartFactory.emptyCartForRandomCustomer();

    Product product1 = TestProductFactory.createTestProduct(euros(12, 99));
    Product product2 = TestProductFactory.createTestProduct(euros(5, 97));

    cart.addProduct(product1, 3);
    cart.addProduct(product2, 5);

    assertThat(cart.numberOfItems()).isEqualTo(8);
    assertThat(cart.subTotal()).isEqualTo(euros(68, 82));
  }

  @Test
  void givenEmptyCart_addProductTwice_numberOfItemsIsCalculatedCorrectly() throws NotEnoughItemsInStockException {
    Cart cart = TestCartFactory.emptyCartForRandomCustomer();
    Product product1 = TestProductFactory.createTestProduct(euros(12, 90));

    cart.addProduct(product1, 3);
    cart.addProduct(product1, 3);

    assertThat(cart.numberOfItems()).isEqualTo(6);
    assertThat(cart.subTotal()).isEqualTo(euros(77, 40));

  }




}