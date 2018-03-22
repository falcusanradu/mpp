package service;

import model.Game;
import repository.GameRepository;

import java.sql.SQLException;
import java.util.List;

public class GameService {

    private GameRepository gameRepository = new GameRepository();

    public List<Game> getAllGames() throws SQLException {
        return this.gameRepository.getAllGames();
    }
}
