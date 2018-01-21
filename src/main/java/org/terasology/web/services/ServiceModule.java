package org.terasology.web.services;

import dagger.Module;
import dagger.Provides;
import io.dropwizard.setup.Environment;
import org.terasology.web.Config;
import org.terasology.web.factory.geo.GeoService;
import org.terasology.web.services.artifactory.ArtifactoryService;
import org.terasology.web.services.artifactory.ArtifactoryServiceImpl;

@Module
public class ServiceModule {
    private Config config;
    private Environment environment;
    private GeoService geoService;

    public ServiceModule(Config config, Environment environment) {
        this.config = config;
        this.environment = environment;

        this.geoService = config.getGeoFactory().build(environment);
    }

    @Provides
    public GeoService provideGeoLocationService() {
        return geoService;
    }

    @Provides
    public ArtifactoryService providerArtifactoryService() {
        return new ArtifactoryServiceImpl();
    }

}
