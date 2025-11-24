package JDBC_CRUD.service;

import JDBC_CRUD.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);                      // returns generated id
    Optional<User> findById(int userId);
    Optional<User> findByUsername(String userName);
    List<User> findAll();
    boolean update(User user);
    boolean delete(int userId);
}
