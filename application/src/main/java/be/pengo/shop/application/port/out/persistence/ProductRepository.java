package be.pengo.shop.application.port.out.persistence;

import be.pengo.shop.model.product.Product;
import be.pengo.shop.model.product.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  List<Product> findByNameOrDescription(String query);

  Optional<Product> findById(ProductId productId);
}
