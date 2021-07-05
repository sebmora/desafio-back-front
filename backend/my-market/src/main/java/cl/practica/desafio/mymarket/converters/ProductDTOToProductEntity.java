package cl.practica.desafio.mymarket.converters;

import cl.practica.desafio.mymarket.domain.ProductDTO;
import cl.practica.desafio.mymarket.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOToProductEntity implements Converter<ProductDTO, ProductEntity> {
    @Override
    public ProductEntity convert(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productDTO.getProductId());
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO.getDescription());
        return productEntity;
    }
}
