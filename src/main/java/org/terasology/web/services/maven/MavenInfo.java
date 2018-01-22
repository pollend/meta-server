package org.terasology.web.services.maven;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

@Root(name = "metadata")
public class MavenInfo {

    @Element(name="groupId")
    private String groupId;
    @Element(name="artifactId")
    private String artifactId;
    @Element(name = "version")
    private String version;

    @Element(name = "versioning")
    private Versioning versioning;

    public static class Versioning{
        @Element(name ="latest")
        public String latest;
        @Element(name ="release")
        public String release;
        @ElementArray(entry = "version")
        public String[] versions;

    }

}
