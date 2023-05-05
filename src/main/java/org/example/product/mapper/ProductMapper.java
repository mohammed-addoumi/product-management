package org.example.product.mapper;

import java.util.List;
import org.example.product.api.ProductDto;
import org.example.product.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDto(Product product);

    List<ProductDto> mapToProductDtoList(List<Product> productList);
}
