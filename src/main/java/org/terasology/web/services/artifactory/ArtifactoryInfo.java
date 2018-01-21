package org.terasology.web.services.artifactory;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class ArtifactoryInfo {
    @JsonProperty("repo")
    public String repo;                  // "terasology-release-local",
    @JsonProperty("path")
    public String path;                  // "/org",
    @JsonProperty("created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    public Date created;               // "2014-11-10T00:57:29.124-05:00",
    @JsonProperty("createdBy")
    public String createdBy;             // "gooey",
    @JsonProperty("lastModified")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    public Date lastModified;            // "2014-11-10T00:57:29.124-05:00",
    @JsonProperty("modifiedBy")
    public String modifiedBy;            // "gooey",

    @JsonProperty("lastUpdated")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    public Date lastUpdated;             // "2014-11-10T00:57:29.124-05:00",

    @JsonProperty("downloadUri")
    public String downloadUri;
    @JsonProperty("mimeType")
    public String mimeType;
    @JsonProperty("size")
    public int size;

    @JsonProperty("children")
    public List<Children> children;

    @JsonProperty("checksum")
    public Checksum checksum;
    @JsonProperty("originalChecksums")
    public Checksum originalChecksums;

    public String uri;

    public static class Checksum {
        @JsonProperty("sha1")
        public String sha1;             // "/terasology",
        @JsonProperty("md5")
        String md5;
    }

    public static class Children {
        @JsonProperty("uri")
        public String uri;             // "/terasology",
        @JsonProperty("folder")
        public boolean folder;
    }
}
