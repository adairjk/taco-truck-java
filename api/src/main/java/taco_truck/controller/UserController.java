package taco_truck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco_truck.model.User;
import taco_truck.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired

    private UserRepository userRepository;

    @GetMapping()
    public @ResponseBody Iterable<User> getAllLocations() {
        return userRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity createUser(@Valid @RequestBody User user, HttpServletRequest request) {
        user.setCreatedOn(new Date());
        userRepository.save(user);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", request.getRequestURL() + "/" + user.getId().toString());
        return new ResponseEntity<User>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody
    User getUserById(@PathVariable("id") Long id) {
        User user = userRepository.findOne(id);
        if(user == null) throw new EmptyResultDataAccessException(0);
        return user;
    }

    @PutMapping("/id/{id}")
    public ResponseEntity updateUser(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody User userDetails) {
        User user = userRepository.findOne(id);
        if(user == null) throw new EmptyResultDataAccessException(0);

        if(userDetails.getFirstName() != null) user.setFirstName(userDetails.getFirstName());
        if(userDetails.getLastName() != null) user.setLastName(userDetails.getLastName());
        if(userDetails.getEmail() != null) user.setEmail(userDetails.getEmail());
        user.setUpdatedOn(new Date());

        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path="/id/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}