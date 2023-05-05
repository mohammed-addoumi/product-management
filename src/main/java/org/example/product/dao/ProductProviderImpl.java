package org.example.product.dao;

import lombok.RequiredArgsConstructor;
import org.example.product.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductProviderImpl implements ProductProvider {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
