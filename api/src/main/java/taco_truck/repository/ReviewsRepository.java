package taco_truck.repository;

import org.springframework.data.repository.CrudRepository;
import taco_truck.model.Reviews;

public interface ReviewsRepository extends CrudRepository<Reviews, Long> {

}
