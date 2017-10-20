package taco_truck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import taco_truck.model.Location;
import taco_truck.model.MenuItem;
import taco_truck.repository.MenuItemRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/menu-items")
public class MenuItemController {
    @Autowired

    private MenuItemRepository menuItemRepository;

    @PostMapping()
    public ResponseEntity createMenuItem(@Valid @RequestBody MenuItem menuItem, HttpServletRequest request) {
        menuItem.setCreatedOn(new Date());
        menuItemRepository.save(menuItem);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", request.getRequestURL() + "/" + menuItem.getId().toString());
        return new ResponseEntity<MenuItem>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody
    MenuItem getById(@PathVariable("id") Long id) {
        return menuItemRepository.findOne(id);
    }

    @GetMapping(path="/location/{id}")
    public @ResponseBody Iterable<MenuItem> getByLocationId(@PathVariable("id") Long id) {
        return menuItemRepository.findMenuItemsByLocationId(id);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity updateMenuItem(@PathVariable(value = "id") Long id,
                                     @Valid @RequestBody MenuItem menuItemDetails) {
        MenuItem menuItem = menuItemRepository.findOne(id);
        if(menuItem == null) throw new EmptyResultDataAccessException(0);

        if(menuItemDetails.getLocationId() != null) menuItem.setLocationId(menuItemDetails.getLocationId());
        if(menuItemDetails.getName() != null) menuItem.setName(menuItemDetails.getName());
        if(menuItemDetails.getDescription() != null) menuItem.setDescription(menuItemDetails.getDescription());
        if(menuItemDetails.getUpdatedBy() != null) menuItem.setUpdatedBy(menuItemDetails.getUpdatedBy());
        menuItem.setUpdatedOn(new Date());

        menuItemRepository.save(menuItem);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path="/id/{id}")
    public ResponseEntity deleteMenuItem(@PathVariable("id") Long id) {
        menuItemRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}