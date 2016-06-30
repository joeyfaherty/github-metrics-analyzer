package com.home.github.domain;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class UserDaoImpl implements UserRepository {

    private HazelcastInstance hazelcastInstance;

    private static final String USER_MAP = "my_in_memory_user_map";

    public UserDaoImpl() {
        hazelcastInstance = Hazelcast.newHazelcastInstance();
    }

    public void save(User user) {
        System.out.println("saving user");
        hazelcastInstance.getMap(USER_MAP).put(user.getId(), user);
    }

    public User retrieve(Long id) {
        System.out.println("retrieving user");
        return (User) hazelcastInstance.getMap(USER_MAP).get(id);
    }

}