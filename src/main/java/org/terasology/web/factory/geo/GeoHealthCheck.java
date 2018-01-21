package org.terasology.web.factory.geo;

import com.codahale.metrics.health.HealthCheck;

public class GeoHealthCheck  extends HealthCheck{
    private GeoService geoService;
    public GeoHealthCheck(GeoService geoService){
        this.geoService = geoService;

    }
    @Override
    protected Result check() throws Exception {
        return null;
    }
}
