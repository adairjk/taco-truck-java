package tacoTruck.controller;

import tacoTruck.model.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping(path="/id/{id}")
    public @ResponseBody Locations getById(@PathVariable("id") Long id) {
        return locationsRepository.findOne(id);
    }

}