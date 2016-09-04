package com.metrics.github.docker.installer;

import com.metrics.github.persistence.jdbc.DatabaseUtility;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runs database migration scripts in default location db/migration
 */
public class FlywayDbMigrator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlywayDbMigrator.class);

    private Flyway flyway;

    public void deployDatabase() {
        flyway = new Flyway();
        String dbUrl = String.format("jdbc:postgresql://%s:%s/%s",
                DatabaseUtility.POSTGRES_HOST,
                DatabaseUtility.POSTGRES_PORT,
                DatabaseUtility.POSTGRES_DATABASE);
        flyway.setDataSource(dbUrl, DatabaseUtility.POSTGRES_USER, DatabaseUtility.POSTGRES_PASSWORD);

        LOGGER.info("starting flyway migration for scripts in location {}", flyway.getLocations()[0]);
        flyway.migrate();
    }

    public static void main(String[] args) {
        FlywayDbMigrator app = new FlywayDbMigrator();
        app.deployDatabase();
    }
}
