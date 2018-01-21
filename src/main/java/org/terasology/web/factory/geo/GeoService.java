package org.terasology.web.factory.geo;

import org.terasology.web.factory.geo.api.GeoIpKeyCheckResponse;
import org.terasology.web.factory.geo.api.GeoIpLocationResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GeoService {
    @GET("/{apikey}/{address}")
    GeoIpLocationResponse getGeoLocation(@Path("apikey")String key, @Path("address")String address);
    @GET("/{apikey}")
    GeoIpKeyCheckResponse getGeoLocation(@Path("apikey") String key);
}
