package com.home.github.domain;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements UserRepository {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private HazelcastInstance hazelcastInstance;

    private static final String USER_MAP = "my_in_memory_user_map";

    public UserDaoImpl() {
        hazelcastInstance = Hazelcast.newHazelcastInstance();
    }

    public void save(User user) {
        LOGGER.debug("Saving user {} with id {}", user.getName(), user.getId());
        hazelcastInstance.getMap(USER_MAP).put(user.getId(), user);
    }

    public User retrieve(Long id) {
        User retrievedUser = (User) hazelcastInstance.getMap(USER_MAP).get(id);
        LOGGER.debug("Retrieving user {} with id {}", retrievedUser.getName(), retrievedUser.getId());
        return retrievedUser;
    }

}