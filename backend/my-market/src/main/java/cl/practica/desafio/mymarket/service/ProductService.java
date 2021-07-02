package cl.practica.desafio.mymarket.service;

import cl.practica.desafio.mymarket.database.ProductRepository;
import cl.practica.desafio.mymarket.domain.ProductDTO;
import cl.practica.desafio.mymarket.domain.ReviewDTO;
import cl.practica.desafio.mymarket.entity.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getProduct() {
        List<ProductDTO> resultado = new ArrayList<>();

        productRepository.findAll().forEach(productEntity -> {
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
            resultado.add(
                    ProductDTO.builder()
                            .productId(productEntity.getProductId())
                            .productName(productEntity.getProductName())
                            .price(productEntity.getPrice())
                            .description(productEntity.getDescription())
                            .reviewDTOList(resultadoReview)
                            .build()
            );
        });
        return resultado ;
    }

    public String createProduct(ProductDTO product) {

        log.info("Insertando el producto" + product);

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(product.getProductId());
        productEntity.setProductName(product.getProductName());
        productEntity.setPrice(product.getPrice());
        productEntity.setDescription(product.getDescription());

        productRepository.save(productEntity);
        return "Producto insertado";

    }

    public String updateProduct(ProductDTO product) {
        if (productRepository.findById(product.getProductId()).isPresent()){
            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductId(product.getProductId());
            productEntity.setProductName(product.getProductName());
            productEntity.setPrice(product.getPrice());
            productEntity.setDescription(product.getDescription());

            productRepository.save(productEntity);
            return "Producto actualizado";
        }
        else {
            return "No se ha encontrado el producto";
        }

    }

    public String deleteProduct(String productId) {
        if (productRepository.findById(productId).isPresent()){
            productRepository.deleteById(productId);
            return "Producto eliminado";
        }
        else{
            return "No se ha encontrado el producto";
        }
    }
}