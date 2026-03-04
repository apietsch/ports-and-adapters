package be.pengo.shop.application.port.in.product;

import be.pengo.shop.model.product.Product;
import java.util.List;

public interface FindProductsUseCase {

  List<Product> findByNameOrDescription(String query);

}
