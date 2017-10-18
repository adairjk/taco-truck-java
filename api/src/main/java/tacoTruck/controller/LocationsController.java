package tacoTruck.controller;

import tacoTruck.model.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import tacoTruck.repository.LocationsRepository;

@Controller
@RequestMapping("/locations")
public class LocationsController {
    @Autowired

    private LocationsRepository locationsRepository;

    @GetMapping(path="")
    public @ResponseBody Iterable<Locations> getAllLocations() {
        return locationsRepository.findAll();
    }

    @PostMapping(path="")
    public ResponseEntity<Locations> createLocation(@Valid @RequestBody Locations location) {
        locationsRepository.save(location);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Locations> getLocationById(@PathVariable("id") Long id) {
        Locations location = locationsRepository.findOne(id);
        if(location == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(location);
    }

    @DeleteMapping(path="/id/{id}")
    public ResponseEntity<Locations> deleteLocationById(@PathVariable("id") Long id) {
        Locations location = locationsRepository.findOne(id);
        if(location == null) {
            return ResponseEntity.notFound().build();
        }

        locationsRepository.delete(location);
        return ResponseEntity.ok().build();
    }

}