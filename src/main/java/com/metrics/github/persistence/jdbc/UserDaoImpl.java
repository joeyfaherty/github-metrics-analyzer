package com.metrics.github.persistence.jdbc;

import com.metrics.github.domain.User;
import com.metrics.github.domain.repositories.UserRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserRepository {

    private Connection connection = DatabaseUtility.getConnection();

    @Override
    public void save(User user) {
        try {
            connection.setAutoCommit(false);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User retrieve(Long id) {
        return null;
    }
}
