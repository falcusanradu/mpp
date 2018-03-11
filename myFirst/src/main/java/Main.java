import model.User;
import repository.UserRepository;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.getAllUsers();
        users.forEach(user -> System.out.println(user.getId() + " " + user.getUsername()));


    }
}
