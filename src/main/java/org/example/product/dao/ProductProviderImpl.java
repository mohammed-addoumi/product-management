package org.example.product.dao;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.product.domain.Product;
import org.springframework.stereotype.Repository;

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
