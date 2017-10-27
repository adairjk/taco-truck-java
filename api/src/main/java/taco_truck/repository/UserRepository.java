package taco_truck.repository;

import org.springframework.data.repository.CrudRepository;
import taco_truck.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
