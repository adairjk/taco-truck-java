package taco_truck.repository;

import org.springframework.data.repository.CrudRepository;

import taco_truck.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {

}
