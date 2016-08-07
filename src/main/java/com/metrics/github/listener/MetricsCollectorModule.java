package com.metrics.github.listener;

import com.google.inject.AbstractModule;

import com.metrics.github.domain.repositories.UserRepository;
import com.metrics.github.persistence.hazelcast.UserDaoImpl;

public class MetricsCollectorModule extends AbstractModule {

        protected void configure() {
            bind(UserRepository.class).to(UserDaoImpl.class);
        }

}
