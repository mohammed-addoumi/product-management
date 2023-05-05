package org.example.product.dao;

import org.example.product.domain.Product;

import java.util.List;

public interface ProductProvider {

    List<Product> getAllProducts();

    Product save(Product product);
}
