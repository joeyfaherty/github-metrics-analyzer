package com.home.github.domain;

import com.google.inject.AbstractModule;

@SuppressWarnings("unused")
public class GithubModule extends AbstractModule {
    protected void configure() {
        bind(UserRepository.class).to(UserDaoImpl.class);
    }
}
