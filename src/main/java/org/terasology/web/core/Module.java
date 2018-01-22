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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private long id;

    @OneToOne(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Maven maven;

    @Column(name = "created_at", nullable = false)
    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;

    @Column(name = "server_side_only", nullable = false)
    @JsonProperty(value = "server_side_only", access = JsonProperty.Access.READ_ONLY)
    private boolean serverSideOnly;

    @Column(name = "description", nullable = false)
    @JsonProperty(value = "description", access = JsonProperty.Access.READ_ONLY)
    private String description;

    @Column(name = "display_name", nullable = false)
    @JsonProperty(value = "display_name", access = JsonProperty.Access.READ_ONLY)
    private String displayName;


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setServerSideOnly(boolean serverSideOnly) {
        this.serverSideOnly = serverSideOnly;
    }

    public boolean getServerSideOnly() {
        return serverSideOnly;
    }

}
