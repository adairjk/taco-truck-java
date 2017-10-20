package taco_truck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import taco_truck.model.Reviews;
import taco_truck.repository.ReviewsRepository;

@Controller
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired

    private ReviewsRepository reviewsRepository;

    @GetMapping(path="/id/{id}")
    public @ResponseBody Reviews getById(@PathVariable("id") Long id) {
        return reviewsRepository.findOne(id);
    }

}