package cl.practica.desafio.mymarket.service;


import cl.practica.desafio.mymarket.database.ReviewRepository;
import cl.practica.desafio.mymarket.domain.ProductDTO;
import cl.practica.desafio.mymarket.domain.ReviewDTO;
import cl.practica.desafio.mymarket.entity.ProductEntity;
import cl.practica.desafio.mymarket.entity.ReviewEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    public List<ReviewDTO> getReview(){
        List<ReviewDTO> resultado = new ArrayList<>();

        reviewRepository.findAll().forEach(reviewEntity -> resultado.add(
                ReviewDTO.builder()
                        .reviewId(reviewEntity.getReviewId())
                        .subject(reviewEntity.getSubject())
                        .description(reviewEntity.getDescription())
                        .date(reviewEntity.getDate())
                        .score(reviewEntity.getScore())
                        .productId(reviewEntity.getProductEntity().getProductId())
                        .build()
                )
        );
        return resultado;
    }

    public String createReview(ReviewDTO review){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(review.getProductId());
        log.info("Insertando la review " + review);

        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setSubject(review.getSubject());
        reviewEntity.setDescription(review.getDescription());
        reviewEntity.setDate(review.getDate());
        reviewEntity.setScore(review.getScore());
        reviewEntity.setProductEntity(productEntity);

        reviewRepository.save(reviewEntity);
        return "Review ingresada";
    }

    public String updateReview(ReviewDTO review){
        log.info("Actualizando review " + review);

        if (reviewRepository.findById(review.getReviewId()).isPresent()){
            ReviewEntity reviewEntity = new ReviewEntity();
            reviewEntity.setReviewId(review.getReviewId());
            reviewEntity.setSubject(review.getSubject());
            reviewEntity.setDescription(review.getDescription());
            reviewEntity.setDate(review.getDate());
            reviewEntity.setScore(review.getScore());

            reviewRepository.save(reviewEntity);
            return "Review actualizada";
        }
        else{
            return "No se ha encontrado la review";
        }

    }

    public String deleteReview(int reviewId){
        if (reviewRepository.findById(reviewId).isPresent()){
            reviewRepository.deleteById(reviewId);
            return "Review eliminada";
        }
        else{
            return "Review no encontrada";
        }
    }
}
