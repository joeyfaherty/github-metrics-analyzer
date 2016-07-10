package com.metrics.github.domain.repositories;

import com.metrics.github.domain.User;

public interface UserRepository {
    void save(User user);
    User retrieve(Long id);
}
