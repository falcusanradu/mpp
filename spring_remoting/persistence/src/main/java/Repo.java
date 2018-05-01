import java.sql.*;

public class Repo {

    private static final String URL = "jdbc:mysql://localhost:3306/mpp_db";
    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "1234";
    protected static Connection connection;

    protected static ResultSet selectQuery(String query) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static void executeUpdate(String query) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
