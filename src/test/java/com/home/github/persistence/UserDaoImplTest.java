package com.home.github.persistence;

import com.home.github.domain.User;
import com.home.github.domain.UserDaoImpl;
import com.home.github.domain.UserRepository;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserDaoImplTest {

    private UserRepository userRepository;

    private static final Long USER_ID = 1L;

    @BeforeTest
    public void setUp() {
        userRepository = new UserDaoImpl();
    }

    @AfterTest
    public void tearDown() {
        // shut down hazelcast TODO
        userRepository = null;
    }

    @Test
    public void save() {
        // save user
        User user = new User(USER_ID);
        user.setName("joey");
        userRepository.save(user);
        // get user
        User retrievedUser = userRepository.retrieve(user.getId());
        assertEquals(retrievedUser.getId(), user.getId());
    }

}