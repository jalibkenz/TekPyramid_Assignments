package JDBC_CRUD.dao;

import JDBC_CRUD.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    int create(User user); // returns generated id
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    boolean update(User user);
    boolean delete(int id);
}
