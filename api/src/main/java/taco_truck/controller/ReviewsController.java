package taco_truck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import taco_truck.model.MenuItem;
import taco_truck.model.Review;
import taco_truck.repository.ReviewRepository;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired

    private ReviewRepository reviewRepository;

    @GetMapping(path="/id/{id}")
    public @ResponseBody
    Review getById(@PathVariable("id") Long id) {
        return reviewRepository.findOne(id);
    }

    @GetMapping(path="/menu-item/{id}")
    public @ResponseBody Iterable<Review> getByMenuItemId(@PathVariable("id") Long id) {
        return reviewRepository.findReviewsByMenuItemId(id);
    }

    @GetMapping(path="/location/{id}")
    public @ResponseBody Iterable<Review> getByLocationId(@PathVariable("id") Long id) {
        return reviewRepository.findReviewsByLocationId(id);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity updateReview(@PathVariable(value = "id") Long id,
                                         @Valid @RequestBody Review reviewDetails) {
        Review review = reviewRepository.findOne(id);
        if(review == null) throw new EmptyResultDataAccessException(0);

        if(reviewDetails.getLocationId() != null) review.setLocationId(reviewDetails.getLocationId());
        if(reviewDetails.getMenuItemId() != null) review.setMenuItemId(reviewDetails.getMenuItemId());
        if(reviewDetails.getDescription() != null) review.setDescription(reviewDetails.getDescription());
        if(reviewDetails.getScore() != null) review.setScore(reviewDetails.getScore());
        if(reviewDetails.getUpdatedBy() != null) review.setUpdatedBy(reviewDetails.getUpdatedBy());
        review.setUpdatedOn(new Date());

        reviewRepository.save(review);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path="/id/{id}")
    public ResponseEntity deleteReview(@PathVariable("id") Long id) {
        reviewRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}