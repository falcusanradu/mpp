package repository;

import entity.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface GameRepository extends CrudRepository<Game, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM game_table g WHERE g.id_game= :id", nativeQuery = true)
    Game findAllById(@Param("id") Integer id);
}
