package com.metrics.github.web.listener;

import com.metrics.github.docker.installer.FlywayDbMigrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by joey on 9/4/16.
 */
public class MetricsContextListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetricsContextListener.class);

    private FlywayDbMigrator flywayDbMigrator = new FlywayDbMigrator();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Context initializing");
        flywayDbMigrator.deployDatabase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Context destroying");
    }
}
