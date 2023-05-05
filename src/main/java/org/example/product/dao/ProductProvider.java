package org.example.product.dao;

import java.util.List;
import org.example.product.domain.Product;

public interface ProductProvider {

    List<Product> getAllProducts();

    Product save(Product product);
}
