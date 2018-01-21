package org.terasology.web.services.artifactory;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Artifactory {
    @GET("/{path}")
    ArtifactoryInfo query(@Path("path")String path);
}