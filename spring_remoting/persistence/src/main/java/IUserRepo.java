import java.sql.SQLException;

public interface IUserRepo {
    public User login(String username, String password) throws SQLException;

    public boolean existsUserByUsername(String username) throws SQLException;
}
