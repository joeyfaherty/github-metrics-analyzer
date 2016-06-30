package com.home.github.domain;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.junit.Assert;

import java.io.IOException;

public class MetricsClient {

    public static void main(String[] args) throws IOException {
        //read
        GithubReader mono = new GithubReader();
        User userToStore = mono.readParseToUserObject();

        Injector injector = Guice.createInjector(new GithubModule());
        UserRepository repository = injector.getInstance(UserRepository.class);
        System.out.println("saving " + userToStore.getId());
        repository.save(userToStore);
        User retrievedUser = repository.retrieve(userToStore.getId());
        System.out.println("retrieved " + retrievedUser.getId());
        Assert.assertEquals(userToStore.getId(), retrievedUser.getId());
        // TODO: shotdown hazelcast
    }
}
