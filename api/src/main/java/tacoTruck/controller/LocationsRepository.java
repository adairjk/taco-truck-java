package tacoTruck.controller;

import org.springframework.data.repository.CrudRepository;

import tacoTruck.model.Locations;

public interface LocationsRepository extends CrudRepository<Locations, Long> {

}
