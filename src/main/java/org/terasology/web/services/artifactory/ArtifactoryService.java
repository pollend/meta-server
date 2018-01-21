package org.terasology.web.services.artifactory;

import java.util.Set;

public interface ArtifactoryService {
    Set<ArtifactoryInfo> findByMatching(Artifactory artifactory, String basePath, String file, boolean isFolder);

    void WalkDirectoryPath(Artifactory artifactory, String basePath,ArtifactoryPathHandler handler);

    Artifactory getArtifactor(String uri);
}
