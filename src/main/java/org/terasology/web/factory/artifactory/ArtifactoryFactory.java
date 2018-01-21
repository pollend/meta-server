package org.terasology.web.factory.artifactory;

import io.dropwizard.jackson.Discoverable;
import io.dropwizard.setup.Environment;
import org.terasology.web.services.artifactory.ArtifactoryServiceImpl;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ArtifactoryFactory implements Discoverable {

    public ArtifactoryServiceImpl build(Environment environment, String name, String uri){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        ArtifactoryServiceImpl artifactoryService =  retrofit.create(ArtifactoryServiceImpl.class);
        return artifactoryService;
    }

}
