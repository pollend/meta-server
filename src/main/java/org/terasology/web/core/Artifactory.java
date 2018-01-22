package org.terasology.web.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Sets;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "artifactory")
public class Artifactory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private long id;

    @Column(name = "created_at", nullable = false)
    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;

    @Column(name = "base_url", nullable = false)
    @JsonProperty(value = "base_url", access = JsonProperty.Access.READ_ONLY)
    private String baseUrl;

    @Column(name = "group", nullable = false)
    @JsonProperty(value = "group", access = JsonProperty.Access.READ_ONLY)
    private String group;

    @Column(name = "path", nullable = false)
    @JsonProperty(value = "path", access = JsonProperty.Access.READ_ONLY)
    private String path;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JsonProperty("maven")
    private Set<Maven> mavenInstances = Sets.newHashSet();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Set<Maven> getMavenInstances() {
        return mavenInstances;
    }

    public boolean addMavenInstance(Maven maven) {
        mavenInstances.add(maven);
        maven.setArtifactory(this);
        return true;
    }

    public boolean removeMavenInstance(Maven maven) {
        mavenInstances.remove(maven);
        maven.setArtifactory(null);
        return true;
    }

}
