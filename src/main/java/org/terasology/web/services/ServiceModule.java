package org.terasology.web.services;

import dagger.Module;
import io.dropwizard.setup.Environment;
import org.terasology.web.Config;

@Module
public class ServiceModule {
    private Config config;
    private Environment environment;

    public ServiceModule(Config config, Environment environment){
        this.config = config;
        this.environment= environment;
    }
}
