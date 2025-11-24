package JDBC_CRUD;

import JDBC_CRUD.model.User;
import JDBC_CRUD.service.UserService;
import JDBC_CRUD.service.imp.UserServiceImp;

import java.util.List;
import java.util.Optional;

public class AppMain {
    public static void main(String[] args) {

        UserService userService = new UserServiceImp();

        // Create a user
        User u = new User("Jalib");
        userService.create(u);

        // Create a user
        u = new User("Kenz");
        userService.create(u);

        // Create a user
        u = new User("Nihal");
        userService.create(u);

        // Create a user
        u = new User("Khaiez");
        userService.create(u);

        // Read user
        Optional<User> user = userService.findById(1);
        System.out.println(user);

        // Delete user
        if(userService.delete(1))System.out.println("Deleted successfully");


        System.out.println("All Users");
        List<User> all = userService.findAll();
        all.forEach(System.out::println);
    }
}
