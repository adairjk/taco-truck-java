package taco_truck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import taco_truck.model.MenuItems;
import taco_truck.repository.MenuItemsRepository;

@Controller
@RequestMapping("/menu-items")
public class MenuItemsController {
    @Autowired

    private MenuItemsRepository menuItemsRepository;

    @GetMapping(path="/id/{id}")
    public @ResponseBody MenuItems getById(@PathVariable("id") Long id) {
        return menuItemsRepository.findOne(id);
    }

}