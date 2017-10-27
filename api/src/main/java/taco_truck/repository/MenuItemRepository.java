package taco_truck.repository;

import org.springframework.data.repository.CrudRepository;
import taco_truck.model.MenuItem;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

    Iterable<MenuItem> findMenuItemsByLocationId(Long id);
}
