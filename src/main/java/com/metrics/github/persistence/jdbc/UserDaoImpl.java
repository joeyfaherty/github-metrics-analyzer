package com.metrics.github.persistence.jdbc;

import com.metrics.github.domain.User;
import com.metrics.github.domain.repositories.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserRepository {

    private Connection connection = DatabaseUtility.getConnection();


    String sql = "INSERT INTO USR (login, id, avatar_url, url)" +
            "VALUES (?, ?, ?, ?)";

    @Override
    public void save(User user) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setLong(2, user.getId());
            preparedStatement.setString(3, user.getAvatarUrl());
            preparedStatement.setString(4, user.getUrl());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User retrieve(Long id) {
        return null;
    }
}
