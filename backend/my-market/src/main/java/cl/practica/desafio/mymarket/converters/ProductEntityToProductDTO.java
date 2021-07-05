package cl.practica.desafio.mymarket.converters;

import cl.practica.desafio.mymarket.domain.ProductDTO;
import cl.practica.desafio.mymarket.domain.ReviewDTO;
import cl.practica.desafio.mymarket.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductEntityToProductDTO implements Converter<ProductEntity, ProductDTO> {

    @Override
    public ProductDTO convert(ProductEntity productEntity) {
        List<ReviewDTO> resultadoReview = productEntity.getReviewList().stream().map(
                reviewEntity -> ReviewDTO.builder()
                        .reviewId(reviewEntity.getReviewId())
                        .subject(reviewEntity.getSubject())
                        .description(reviewEntity.getDescription())
                        .date(reviewEntity.getDate())
                        .score(reviewEntity.getScore())
                        .productId(reviewEntity.getProductEntity().getProductId())
                        .build()
        ).collect(Collectors.toList());
        return ProductDTO.builder()
                .productId(productEntity.getProductId())
                .productName(productEntity.getProductName())
                .price(productEntity.getPrice())
                .description(productEntity.getDescription())
                .quantity(productEntity.getStockEntity().getQuantity())
                .reviewDTOList(resultadoReview)
                .build();
    }
}
