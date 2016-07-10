package com.metrics.github.persistence.hazelcast;

import com.metrics.github.domain.User;
import com.metrics.github.domain.repositories.UserRepository;

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
        userRepository = null;
    }

    @Test
    public void testSaveAndRetrieve() {
        // save user
        User user = new User(USER_ID);
        user.setName("joey");
        userRepository.save(user);
        // get user
        User retrievedUser = userRepository.retrieve(user.getId());
        assertEquals(retrievedUser.getId(), user.getId());
    }

}