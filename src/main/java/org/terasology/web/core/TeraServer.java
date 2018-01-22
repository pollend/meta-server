package org.terasology.web.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tera_server")
@NamedQueries({
    @NamedQuery(
        name = "org.terasology.web.core.TeraServer.findAll",
        query = "SELECT * FROM Server s"
    )
})
public class TeraServer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value =  "id", access = JsonProperty.Access.READ_ONLY)
    private long id;

    @Column(name = "created_at", nullable = false)
    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @JsonProperty(value = "updated_at", access = JsonProperty.Access.READ_ONLY)
    private Date updatedAt;

    @Column(name = "name", nullable = false,length = 256)
    @JsonProperty("name")
    private String name;

    @Column(name = "owner", nullable = false,length = 256)
    @JsonProperty("owner")
    private String owner;

    @Column(name = "address", nullable = false,length = 256)
    @JsonProperty("address")
    private String address;


    @Column(name = "port", nullable = false)
    @JsonProperty("port")
    private int port;

    @Column(name = "country", nullable = false)
    @JsonProperty("country")
    private int country;


    @Column(name = "state_providence", nullable = false)
    @JsonProperty("state_providence")
    private int stateProvidence;


    @Column(name = "active", nullable = false)
    @JsonProperty("active")
    private boolean active = false;

    @JsonProperty("secrete")
    private String secrete;

    public void setSecrete(String secrete) {
        this.secrete = secrete;
    }

    public String getSecrete() {
        return secrete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getStateProvidence() {
        return stateProvidence;
    }

    public void setStateProvidence(int stateProvidence) {
        this.stateProvidence = stateProvidence;
    }

    public boolean getActive(){
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

