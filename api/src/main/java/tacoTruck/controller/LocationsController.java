package tacoTruck.controller;

import tacoTruck.model.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/locations")
public class LocationsController {
    @Autowired

    private LocationsRepository locationsRepository;

    @GetMapping(path="")
    public @ResponseBody Iterable<Locations> getAllLocations() {
        return locationsRepository.findAll();
    }

}