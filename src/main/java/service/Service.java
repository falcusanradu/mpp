package service;

import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;

import java.sql.SQLException;

@org.springframework.stereotype.Service
public class Service {

    UserRepository userRepository = new UserRepository();

    public boolean login(String username, String password) throws SQLException {
        if (this.userRepository.login(username, password) != null) {
            return true;
        }
        return false;
    }
}
