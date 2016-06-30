package com.home.github.domain;

public interface UserRepository {
    void save(User user);
    User retrieve(Long id);
}
