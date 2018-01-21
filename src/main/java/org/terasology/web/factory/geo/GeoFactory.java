package org.terasology.web.factory.geo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.jackson.Discoverable;
import io.dropwizard.setup.Environment;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class GeoFactory implements Discoverable {
    protected String apiKey;

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.db-ip.com/v2/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    @JsonProperty("key")
    public final void setApiKey(final String key) {
        this.apiKey = key;
    }

    @JsonProperty("key")
    public final String getApiKey() {
        return this.apiKey;
    }


    public GeoService build(Environment environment){
        GeoService geoService = retrofit.create(GeoService.class);
        environment.healthChecks().register("geo-ip",new GeoHealthCheck(geoService));
        return geoService;
    }

}
