package org.terasology.web.factory.geo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class GeoIpKeyCheckResponse {
    private String apiKey;
    private long queriesPerDay;
    private long queriesLeft;
    private Date expires;

    @JsonProperty("apiKey")
    public String getApiKey() {
        return apiKey;
    }

    @JsonProperty("apiKey")
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @JsonProperty("queriesPerDay")
    public long getQueriesPerDay() {
        return queriesPerDay;
    }

    @JsonProperty("queriesPerDay")
    public void setQueriesPerDay(long queriesPerDay) {
        this.queriesPerDay = queriesPerDay;
    }

    @JsonProperty("queriesLeft")
    public long getQueriesLeft() {
        return queriesLeft;
    }

    @JsonProperty("queriesLeft")
    public void setQueriesLeft(long queriesLeft) {
        this.queriesLeft = queriesLeft;
    }

    @JsonProperty("expires")
    public Date getExpires() {
        return expires;
    }

    @JsonProperty("expires")
    public void setExpires(Date expires) {
        this.expires = expires;
    }
}
