package cl.practica.desafio.mymarket.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReviewDTO {
    private int reviewId;
    private String subject;
    private String description;
    private Date date;
    private int score;
    private String productId;
}
