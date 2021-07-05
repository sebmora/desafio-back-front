package cl.practica.desafio.mymarket.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDTO {
    private int stockId;
    private int quantity;
    private String productId;
}
