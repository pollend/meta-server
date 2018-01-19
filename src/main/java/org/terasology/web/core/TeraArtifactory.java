package org.terasology.web.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "artifactory")
public class TeraArtifactory {
    public enum RepoType {
        RELEASE(1),
        SNAPSHOT(2);

        private final long mask;

        RepoType(long level) {
            this.mask = level;
        }

        public long getMask() {
            return mask;
        }
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private long id;

    @Column(name = "created_at", nullable = false)
    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @JsonProperty(value = "updated_at", access = JsonProperty.Access.READ_ONLY)
    private Date updatedAt;

    @Column(name = "base_url", nullable = false)
    @JsonProperty(value = "base_url", access = JsonProperty.Access.READ_ONLY)
    private String baseUrl;

    @Column(name = "repo_name", nullable = false)
    @JsonProperty(value = "repo_name", access = JsonProperty.Access.READ_ONLY)
    private String repoName;

    @Column(name = "group", nullable = false)
    @JsonProperty(value = "group", access = JsonProperty.Access.READ_ONLY)
    private String group;

    @Column(name = "type", nullable = false)
    @JsonProperty(value = "type", access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private RepoType type;

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

    public RepoType getType() {
        return type;
    }

    public void setType(RepoType type) {
        this.type = type;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoName() {
        return repoName;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
