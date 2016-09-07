package com.metrics.github.web.listener;

import com.metrics.github.eventhandling.EventHandler;
import com.metrics.github.persistence.flyway.FlywayDbMigrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by joey on 9/4/16.
 */
public class MetricsContextListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetricsContextListener.class);

    // TODO: introduce DI?
    private FlywayDbMigrator flywayDbMigrator = new FlywayDbMigrator();
    private EventHandler eventHandler = new EventHandler();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Context initializing");
        flywayDbMigrator.deployDatabase();
        eventHandler.readAndSave();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Context destroying");
    }
}
