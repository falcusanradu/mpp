package repository;

import model.Game;
import model.User;
import org.springframework.util.IdGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameRepository extends Repo implements IGameRepository {

    @Override
    public List<Game> getAllGames() throws SQLException {
        List<Game> games = new ArrayList<>();

        ResultSet rs = selectQuery("SELECT * FROM game_table");

        while (rs.next()) {
            Game game = new Game();
            game.setId(rs.getInt("id_game"));
            game.setTeam1(rs.getString("team1"));
            game.setTeam2(rs.getString("team2"));
            game.setTitle(rs.getString("game_title"));
            game.setTickets(rs.getInt("available_tickets"));
            game.setPriceOfTicket(rs.getInt("price_of_one_ticket"));
            games.add(game);
        }
        connection.close();

        return games;
    }

    @Override
    public boolean existsEnoughTickets(Integer id, Integer nrTicketsWanted) throws SQLException {
        // available_tickets
        ResultSet rs = selectQuery("SELECT * FROM game_table WHERE id_game ='" + id +
                "' AND available_tickets >='" + nrTicketsWanted + "'");

        if (rs.first()) {
            connection.close();
            return true;
        }
        connection.close();
        return false;
    }

    @Override
    public Game findGameById(Integer id) throws SQLException {
        ResultSet rs = Repo.selectQuery("SELECT * FROM game_table WHERE id_game='" + id + "'");
        if (rs.first()) {
            Game game = new Game();
            game.setId(rs.getInt("id_game"));
            game.setTeam1(rs.getString("team1"));
            game.setTeam2(rs.getString("team2"));
            game.setTitle(rs.getString("game_title"));
            game.setTickets(rs.getInt("available_" +
                    "" +
                    "tickets"));
            game.setPriceOfTicket(rs.getInt("price_of_one_ticket"));
            Repo.connection.close();
            return game;
        }
        Repo.connection.close();
        return null;
    }

    @Override
    public boolean updatenrTicketsAfterBuying(Integer id, Integer nrTicketsWanted) throws SQLException {
        Game game = this.findGameById(id);
        Repo.executeUpdate("UPDATE game_table SET available_tickets =" + (game.getTickets() - nrTicketsWanted)
                + " WHERE id_game='" + id + "'");
        return false;
    }


//    @Override
//    public boolean existsGameById(Integer id) throws SQLException {
//        ResultSet rs = selectQuery("SELECT * FROM game_table WHERE id_game ='" + id + "'");
//
//        if (rs.first()) {
//            connection.close();
//            return true;
//        }
//        connection.close();
//        return false;
//    }


}
