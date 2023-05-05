package org.example.product.api;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.product.command.ProductCommand;
import org.example.product.domain.Product;
import org.example.product.mapper.ProductMapper;
import org.example.product.services.ProductService;
import org.example.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDto>>> getAllProducts() {
        List<ProductDto> productDtos =
                productMapper.mapToProductDtoList(productService.getAllProducts());
        ApiResponse<List<ProductDto>> okResponse = ApiResponse.ok(productDtos);
        return ResponseEntity.ok(okResponse);
    }

    @PostMapping
    public ResponseEntity<ProductDto> addNewProduct(
            @Valid @RequestBody ProductCommand productCommand) {
        Product product = productService.addNewProduct(productCommand);
        ProductDto productDto = productMapper.productToProductDto(product);
        URI location =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(productDto.getId())
                        .toUri();
        return ResponseEntity.created(location).body(productDto);
    }
}
