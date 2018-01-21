package org.terasology.web.services.artifactory;

import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.nio.file.Paths;
import java.util.Queue;
import java.util.Set;

public class ArtifactoryServiceImpl implements ArtifactoryService {

    @Override
    public Artifactory getArtifactor(String uri) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(uri + "/api/storage")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit.create(Artifactory.class);
    }

    @Override
    public void WalkDirectoryPath(Artifactory artifactory, String basePath, ArtifactoryPathHandler handler) {
        Queue<String> toWalk = Queues.newArrayDeque();
        toWalk.add(basePath);
        while (toWalk.size() > 0) {
            String current = toWalk.remove();
            ArtifactoryInfo info = artifactory.query(Paths.get(current).toString());
            if (!handler.handle(info))
                continue;
            for (ArtifactoryInfo.Children child : info.children) {
                if (child.folder) {
                    toWalk.add(current + child.uri);
                }
            }
        }
    }

    @Override
    public Set<ArtifactoryInfo> findByMatching(Artifactory artifactory, String basePath, String file, boolean isFolder) {
        Set<ArtifactoryInfo> maven = Sets.newHashSet();
        WalkDirectoryPath(artifactory, basePath, info -> {
            for (ArtifactoryInfo.Children child : info.children) {
                if (child.folder == isFolder && child.uri.equals(file)) {
                    maven.add(artifactory.query(info.uri + child.uri));
                    return false;
                }
            }
            return true;
        });
        return maven;
    }
}
