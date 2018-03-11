package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {


    private static final String URL = "jdbc:mysql://localhost:3306/mpp_db";
    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "1234";

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_table");

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


}
