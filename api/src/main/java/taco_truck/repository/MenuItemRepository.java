package taco_truck.repository;

import org.springframework.data.repository.CrudRepository;
import taco_truck.model.MenuItem;

import java.util.List;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

    List<MenuItem> findMenuItemsByLocationId(Long id);
}
