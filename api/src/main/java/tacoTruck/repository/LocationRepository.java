package tacoTruck.repository;

import org.springframework.data.repository.CrudRepository;

import tacoTruck.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {

}
