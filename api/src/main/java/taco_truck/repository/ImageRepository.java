package taco_truck.repository;

import org.springframework.data.repository.CrudRepository;
import taco_truck.model.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
