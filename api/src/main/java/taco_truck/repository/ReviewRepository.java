package taco_truck.repository;

import org.springframework.data.repository.CrudRepository;
import taco_truck.model.Review;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findReviewsByMenuItemId(Long id);
    List<Review> findReviewsByLocationId(Long id);
    List<Review> findReviewsByCreatedBy(String username);

}
