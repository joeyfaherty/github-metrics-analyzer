package com.home.github.domain;

import org.testng.Assert;

import java.io.IOException;

public class MetricsClient {

    public static void main(String[] args) throws IOException {
        //read
        GithubReader reader = new GithubReader();
        User userToStore = reader.readParseToUserObject();

        // no need for guice currently
        /*Injector injector = Guice.createInjector(new GithubModule());
        UserRepository repository = injector.getInstance(UserRepository.class);*/
        UserRepository repository = new UserDaoImpl();
        repository.save(userToStore);
        User retrievedUser = repository.retrieve(userToStore.getId());
        Assert.assertEquals(userToStore.getId(), retrievedUser.getId());
        // TODO: shotdown hazelcast
    }
}
