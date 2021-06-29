package cl.practica.desafio.mymarket.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private String productId;
    private String productName;
    private int price;
    private String description;
}