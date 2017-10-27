package taco_truck.repository;

import org.springframework.data.repository.CrudRepository;
import taco_truck.model.Favorite;

public interface FavoriteRepository extends CrudRepository<Favorite, Long> {

    Iterable<Favorite> findFavoritesByUserId(Long id);
}
