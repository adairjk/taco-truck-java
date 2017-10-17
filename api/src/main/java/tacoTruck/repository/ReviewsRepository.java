package tacoTruck.repository;

import org.springframework.data.repository.CrudRepository;
import tacoTruck.model.Reviews;

public interface ReviewsRepository extends CrudRepository<Reviews, Long> {

}
