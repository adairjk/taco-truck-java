package taco_truck.repository;

import org.springframework.data.repository.CrudRepository;
import taco_truck.model.MenuItems;

public interface MenuItemsRepository extends CrudRepository<MenuItems, Long> {

}
