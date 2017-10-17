package tacoTruck.repository;

import org.springframework.data.repository.CrudRepository;
import tacoTruck.model.MenuItems;

public interface MenuItemsRepository extends CrudRepository<MenuItems, Long> {

}
