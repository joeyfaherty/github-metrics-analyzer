package com.metrics.github.listener;

import com.google.inject.Guice;
import com.google.inject.Injector;

import com.metrics.github.domain.User;
import com.metrics.github.domain.repositories.UserRepository;
import com.metrics.github.service.GithubReader;

import org.testng.Assert;

import java.io.IOException;

public class MetricsClient {

    public static void main(String[] args) throws IOException {
        //read
        GithubReader mono = new GithubReader();
        User userToStore = mono.readParseToUserObject();

        Injector injector = Guice.createInjector(new MetricsCollectorModule());
        UserRepository repository = injector.getInstance(UserRepository.class);
        System.out.println("saving " + userToStore.getId());
        repository.save(userToStore);
        User retrievedUser = repository.retrieve(userToStore.getId());
        System.out.println("retrieved " + retrievedUser.getId());
        Assert.assertEquals(userToStore.getId(), retrievedUser.getId());
    }
}
