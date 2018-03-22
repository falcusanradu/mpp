import UI.AfterLoginEclipse;
import UI.SwingGUIEclipse;
import model.User;
import repository.UserRepository;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private SwingGUIEclipse swingGUIEclipse ;
    private AfterLoginEclipse afterLoginEclipse;

    public static void main(String[] args) throws SQLException {
        SwingGUIEclipse swingGUIEclipse = new SwingGUIEclipse();

//        UserRepository userRepository = new UserRepository();
//        List<User> users = userRepository.getAllUsers();
//        users.forEach(user -> System.out.println(user.getId() + " " + user.getUsername()));

        // userRepository.deleteUserById(2);
        // userRepository.updateUserById(2);
        // userRepository.insertUser();

    }


}
