package com.home.github.domain;

import com.google.inject.AbstractModule;

public class GithubModule extends AbstractModule {
    protected void configure() {
        bind(UserRepository.class).to(UserDaoImpl.class);
    }
}
