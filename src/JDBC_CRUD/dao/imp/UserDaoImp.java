package JDBC_CRUD.dao.imp;

import JDBC_CRUD.dao.UserDao;
import JDBC_CRUD.db.DBConnection;
import JDBC_CRUD.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImp implements UserDao {


    private static final String INSERT_SQL = "INSERT INTO userMaster (userName) VALUES (?)";
    private static final String SELECT_BY_ID = "SELECT userId, userName FROM userMaster WHERE userId = ?";
    private static final String SELECT_BY_USERNAME = "SELECT userId, userName FROM userMaster WHERE userName = ?";
    private static final String SELECT_ALL = "SELECT userId, userName FROM userMaster";
    private static final String UPDATE_SQL = "UPDATE userMaster SET userId = ?, userName = ? WHERE userId = ?";
    private static final String DELETE_SQL = "DELETE FROM userMaster WHERE userId = ?";


    @Override
    public int create(User user) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getUserName());

            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Creating user failed, no rows affected.");

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






    @Override
    public Optional<User> findById(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_USERNAME)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }


    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean update(User user) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {

            ps.setLong(1, user.getUserId());
            ps.setString(2, user.getUserName());
            ps.setLong(3, user.getUserId());

            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean delete(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    //mapRow() is internal to the implementation, not part of the public API.
    //not part of DAO, just part of Implementation
    private User mapRow(ResultSet rs) throws SQLException {
        User u = new User();
        u.setUserId(rs.getInt("userId"));
        u.setUserName(rs.getString("userName"));
        return u;
    }
}
