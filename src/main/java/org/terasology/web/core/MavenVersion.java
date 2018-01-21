package org.terasology.web.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "maven_version")
public class MavenVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty("module")
    private Module module;


    @Column(name = "is_latest", nullable = false)
    @JsonProperty(value = "is_latest", access = JsonProperty.Access.READ_ONLY)
    private boolean isLatest;

    public boolean getIsLatest() {
        return isLatest;
    }

    public void setIsLatest(boolean value) {
        this.isLatest = value;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
