package tacoTruck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tacoTruck.model.Reviews;
import tacoTruck.repository.ReviewsRepository;

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