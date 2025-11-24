package JDBC_CRUD.service.imp;

import JDBC_CRUD.dao.UserDao;
import JDBC_CRUD.dao.imp.UserDaoImp;
import JDBC_CRUD.model.User;
import JDBC_CRUD.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserServiceImp implements UserService {

    private final UserDao userDao;


    public UserServiceImp() {
        this.userDao = new UserDaoImp();  // or whatever you use
    }




    @Override
    public User create(User user) {
        validateForCreate(user);
        int generatedId = userDao.create(user);
        user.setUserId(generatedId);
        return user;
    }

    @Override
    public Optional<User> findById(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean update(User user) {
        validateForUpdate(user);
        return userDao.update(user);
    }

    @Override
    public boolean delete(int userId) {
        if (userId <= 0) throw new IllegalArgumentException("invalid userId");
        return userDao.delete(userId);
    }


    // --- simple validations ---
    private void validateForCreate(User user) {
        if (user == null) throw new IllegalArgumentException("user must not be null");
        if (user.getUserName() == null || user.getUserName().isBlank())
            throw new IllegalArgumentException("userName is required");
        // don't allow client to set id for create
        if (user.getUserId() > 0)
            throw new IllegalArgumentException("userId should not be set for a new user");
    }

    private void validateForUpdate(User user) {
        if (user == null) throw new IllegalArgumentException("user must not be null");
        if (user.getUserId() <= 0) throw new IllegalArgumentException("userId is required for update");
        if (user.getUserName() == null || user.getUserName().isBlank())
            throw new IllegalArgumentException("userName is required");
    }

}
