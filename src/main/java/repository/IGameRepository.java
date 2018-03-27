package repository;

import model.Game;

import java.sql.SQLException;
import java.util.List;

public interface IGameRepository {
    public List<Game> getAllGames() throws SQLException;

    public boolean existsEnoughTickets(Integer id, Integer nrTicketsWanted) throws SQLException;

    public Game findGameById(Integer id) throws SQLException;
    public boolean updatenrTicketsAfterBuying(Integer id, Integer nrTicketsWanted) throws SQLException;

}
