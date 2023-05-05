package org.example.product.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.product.command.ProductCommand;
import org.example.product.dao.ProductProvider;
import org.example.product.domain.Product;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductProvider productProvider;

    public List<Product> getAllProducts() {
        return productProvider.getAllProducts();
    }

    public Product addNewProduct(ProductCommand productCommand) {
        Product product = Product.from(productCommand);
        product = productProvider.save(product);
        return product;
    }
}
