package com.metrics.github.eventhandling;

import com.metrics.github.domain.User;
import com.metrics.github.domain.repositories.UserRepository;
import com.metrics.github.persistence.jdbc.UserDaoImpl;
import com.metrics.github.service.GithubReader;

/**
 * Created by joey on 9/4/16.
 */
public class EventHandler {

    private GithubReader githubReader = new GithubReader();
    private UserRepository userRepository = new UserDaoImpl();

/*    public EventHandler(GithubReader githubReader, UserRepository userRepository) {
        this.githubReader = githubReader;
        this.userRepository = userRepository;
    }*/

    public void readAndSave() {
        User user = githubReader.readParseToUserObject();
        userRepository.save(user);
    }

}
