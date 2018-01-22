package org.terasology.web.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "maven")
public class Maven {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private long id;

    @ManyToOne
    @JoinColumn(name="artifactory_id", nullable=false,insertable = false,updatable = false)
    @JsonProperty("artifactory")
    private Artifactory artifactory;

    @Column(name = "release_version")
    private String releaseVersion;

    @Column(name = "latest_version")
    private String latestVersion;

    @Column(name = "group_version")
    private String groupVersion;

    @Column(name = "base_url")
    private String baseUrl;

    @Column(name = "version")
    private String version;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "last_updated")
    private long lastUpdated;

    @Column(name = "artifact_id")
    private String artifactId;

    @JoinColumn(name = "maven_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Module module;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setArtifactory(Artifactory artifactory) {
        this.artifactory = artifactory;
    }

    public Artifactory getArtifactory() {
        return artifactory;
    }

    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setGroupVersion(String groupVersion) {
        this.groupVersion = groupVersion;
    }

    public String getGroupVersion() {
        return groupVersion;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getArtifactId() {
        return artifactId;
    }
}
