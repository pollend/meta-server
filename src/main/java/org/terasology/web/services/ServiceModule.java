package org.terasology.web.services;

import dagger.Module;
import dagger.Provides;
import io.dropwizard.setup.Environment;
import org.terasology.web.Config;
import org.terasology.web.services.geo.GeoLocationService;
import org.terasology.web.services.geo.dbip.GeoLocationServiceDbIp;

@Module
public class ServiceModule {
    private Config config;
    private Environment environment;

    public ServiceModule(Config config, Environment environment){
        this.config = config;
        this.environment= environment;
    }

    @Provides
    public GeoLocationService provideGeoLocationService() {
        return new GeoLocationServiceDbIp(this.config.getGeoKey());
    }


}
