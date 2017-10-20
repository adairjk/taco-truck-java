package tacoTruck.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacoTruck.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

import tacoTruck.repository.LocationRepository;
import java.util.Date;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired

    private LocationRepository locationRepository;

    @GetMapping()
    public @ResponseBody Iterable<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity createLocation(@Valid @RequestBody Location location, HttpServletRequest request) {
        location.setCreatedOn(new Date());
        locationRepository.save(location);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", request.getRequestURL() + "/" + location.getId().toString());
        return new ResponseEntity<Location>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody
    Location getLocationById(@PathVariable("id") Long id) {
        Location location = locationRepository.findOne(id);
        if(location == null) throw new EmptyResultDataAccessException(0);
        return location;
    }

    @PutMapping("/id/{id}")
    public ResponseEntity updateNote(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Location locationDetails) {
        Location location = locationRepository.findOne(id);
        if(location == null) throw new EmptyResultDataAccessException(0);

        if(locationDetails.getName() != null) location.setName(locationDetails.getName());
        if(locationDetails.getAddress() != null) location.setAddress(locationDetails.getAddress());
        if(locationDetails.getCity() != null) location.setCity(locationDetails.getCity());
        if(locationDetails.getState() != null) location.setState(locationDetails.getState());
        if(locationDetails.getZip() != null) location.setZip(locationDetails.getZip());
        if(locationDetails.getUpdatedBy() != null) location.setUpdatedBy(locationDetails.getUpdatedBy());
        location.setUpdatedOn(new Date());

        locationRepository.save(location);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path="/id/{id}")
    public ResponseEntity deleteLocationById(@PathVariable("id") Long id) {
        locationRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}