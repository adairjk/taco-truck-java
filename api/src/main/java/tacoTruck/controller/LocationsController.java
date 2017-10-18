package tacoTruck.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacoTruck.model.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import tacoTruck.repository.LocationsRepository;

import java.util.Date;

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
    public ResponseEntity createLocation(@Valid @RequestBody Locations location) {
        location.setCreatedOn(new Date());
        locationsRepository.save(location);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", "http://localhost:8080/locations/id/" + location.getId().toString());
        return new ResponseEntity<Locations>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping(path="/id/{id}")
    public ResponseEntity<Locations> getLocationById(@PathVariable("id") Long id) {
        Locations location = locationsRepository.findOne(id);
        if(location == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(location);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Locations> updateNote(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Locations locationDetails) {
        Locations location = locationsRepository.findOne(id);
        if(location == null) {
            return ResponseEntity.notFound().build();
        }

        if(locationDetails.getName() != null) location.setName(locationDetails.getName());
        if(locationDetails.getAddress() != null) location.setAddress(locationDetails.getAddress());
        if(locationDetails.getCity() != null) location.setCity(locationDetails.getCity());
        if(locationDetails.getState() != null) location.setState(locationDetails.getState());
        if(locationDetails.getZip() != null) location.setZip(locationDetails.getZip());
        if(locationDetails.getUpdatedBy() != null) location.setUpdatedBy(locationDetails.getUpdatedBy());
        location.setUpdatedOn(new Date());

        Locations updatedLocation = locationsRepository.save(location);
        return ResponseEntity.ok(updatedLocation);
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