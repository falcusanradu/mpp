package repository;

import model.Game;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameRepository extends Repo {

    public List<Game> getAllGames() throws SQLException {
        List<Game> games = new ArrayList<>();

        ResultSet rs = selectQuery("SELECT * FROM game_table");

        while (rs.next()) {
            Game game = new Game();
            game.setId(rs.getInt("id_game"));
            game.setTeam1(rs.getString("team1"));
            game.setTeam2(rs.getString("team2"));
            game.setTitle(rs.getString("game_title"));
            game.setTickets(rs.getInt("tickets"));
            games.add(game);
        }
        connection.close();

        return games;
    }

}
