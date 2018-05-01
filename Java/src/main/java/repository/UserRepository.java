package repository;

import model.Game;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends Repo implements IUserRepo {

    @Override
    public User login(String username, String password) throws SQLException {
        ResultSet rs = this.selectQuery(
                "SELECT * FROM user_table WHERE username ='" + username + "' AND passwd ='" + password + "'");

        if (rs.first()) {
            User user = new User();
            return user;
        }
        connection.close();
        return null;

    }

    @Override
    public boolean existsUserByUsername(String username) throws SQLException {
        ResultSet rs = selectQuery("SELECT * FROM game_table WHERE id_game ='" + username + "'");
        if (rs.first()) {
            connection.close();
            return true;
        }
        connection.close();
        return false;
    }


//    public List<User> getAllUsers() throws SQLException {
//        List<User> users = new ArrayList<User>();
//
//        ResultSet rs = selectQuery("SELECT * FROM user_table");
//
//        while (rs.next()) {
//            User user = new User();
//            user.setId(rs.getInt("id_user"));
//            user.setUsername(rs.getString("username"));
//            users.add(user);
//        }
//        connection.close();
//
//        return users;
//    }
//
//    public void deleteUserById(int id) throws SQLException {
//        executeUpdate("DELETE FROM user_table WHERE id_user=" + id);
//        connection.close();
//    }
//
//    public void updateUserById(int id) throws SQLException {
//        executeUpdate("UPDATE user_table SET username = 'updatedUsername', address = 'newADDRESS' WHERE id_user=" + id);
//        connection.close();
//    }
//
//    public void insertUser() throws SQLException {
//        executeUpdate(
//                "INSERT INTO user_table (id_user, username, passwd) VALUES (101, 'insertedUser', 'insertedpass')");
//        connection.close();
//    }

}
