package taco_truck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco_truck.model.Favorite;
import taco_truck.repository.FavoriteRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
    @Autowired

    private FavoriteRepository favoriteRepository;

    @GetMapping()
    public @ResponseBody Iterable<Favorite> getAllLocations() {
        return favoriteRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity createFavorite(@Valid @RequestBody Favorite favorite, HttpServletRequest request) {
        favorite.setCreatedOn(new Date());
        favoriteRepository.save(favorite);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", request.getRequestURL() + "/" + favorite.getId().toString());
        return new ResponseEntity<Favorite>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody
    Favorite getFavoriteById(@PathVariable("id") Long id) {
        Favorite favorite = favoriteRepository.findOne(id);
        if(favorite == null) throw new EmptyResultDataAccessException(0);
        return favorite;
    }

    @GetMapping(path="/user/{id}")
    public @ResponseBody Iterable<Favorite> getFavoritesByUserId(@PathVariable("id") Long id) {
        return favoriteRepository.findFavoritesByUserId(id);
    }

    @DeleteMapping(path="/id/{id}")
    public ResponseEntity deleteFavorite(@PathVariable("id") Long id) {
        favoriteRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}