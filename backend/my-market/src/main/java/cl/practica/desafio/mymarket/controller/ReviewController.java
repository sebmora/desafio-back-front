package cl.practica.desafio.mymarket.controller;

import cl.practica.desafio.mymarket.domain.ReviewDTO;
import cl.practica.desafio.mymarket.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ReviewDTO> getReview() {
        return reviewService.getReview();
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    public String createReview(@RequestBody ReviewDTO review) {
        return reviewService.createReview(review);
    }

    // UPDATE
    @RequestMapping(method = RequestMethod.PUT)
    public String updateReview(@RequestBody ReviewDTO review) {
        return reviewService.updateReview(review);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteReview(@RequestParam int reviewId) {
        return reviewService.deleteReview(reviewId);
    }
}
