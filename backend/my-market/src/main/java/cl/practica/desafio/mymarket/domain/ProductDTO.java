package cl.practica.desafio.mymarket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String productId;
    private String productName;
    private int price;
    private String description;
    private int quantity;
    private List<ReviewDTO> reviewDTOList;
}