package org.terasology.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayFactory;
import org.terasology.web.factory.geo.GeoFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Config extends Configuration {
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();


    @Valid
    @NotNull
    @JsonProperty("flyway")
    private FlywayFactory flyway = new FlywayFactory();

    @Valid
    @NotNull
    @JsonProperty("geo")
    private GeoFactory geoFactory = new GeoFactory();

    @Valid
    @NotNull
    @JsonProperty("secrete")
    private String serverSecrete;

    public FlywayFactory getFlyway() {
        return flyway;
    }

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public String getServerSecrete() {
        return serverSecrete;
    }

    public GeoFactory getGeoFactory() {
        return geoFactory;
    }
}

