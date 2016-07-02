package com.home.github.domain.repositories;

import com.home.github.domain.User;

public interface UserRepository {
    void save(User user);
    User retrieve(Long id);
}
