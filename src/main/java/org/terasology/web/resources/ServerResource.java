/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.web.resources;

import io.dropwizard.jersey.params.LongParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terasology.web.core.TeraServer;
import org.terasology.web.db.TeraServerDAO;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 */
@Path("/servers/")
public class ServerResource {

    private static final Logger logger = LoggerFactory.getLogger(ServerResource.class);
    private final TeraServerDAO serverDAO;

    public ServerResource(TeraServerDAO serverDAO) {
        this.serverDAO = serverDAO;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeraServer> list(){
        return this.serverDAO.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TeraServer get(@PathParam("id") LongParam serverId) {
        TeraServer server = this.serverDAO.findById(serverId.get());
        if (server == null) {
            throw new NotFoundException("TeraServer Not Found");
        }
        return server;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TeraServer put(@PathParam("id") LongParam serverId, @Valid TeraServer server){
        server.setId(serverId.get());
        serverDAO.update(server);
        return server;
    }

//
//    @GET
//    @Path("show")
//    @Produces(MediaType.TEXT_HTML)
//    public Viewable show() {
//        logger.info("Requested server list as HTML");
//        ImmutableMap<Object, Object> dataModel = ImmutableMap.builder()
//                .put("items", list())
//                .put("version", VersionInfo.getVersion())
//                .build();
//        return new Viewable("/server-list.ftl", dataModel);
//    }
//
//    @GET
//    @Path("add")
//    @Produces(MediaType.TEXT_HTML)
//    public Viewable add() {
//        logger.info("Requested add as HTML");
//        ImmutableMap<Object, Object> dataModel = ImmutableMap.builder()
//                .put("name", "")
//                .put("address", "")
//                .put("port", 25777)
//                .put("owner", "")
//                .put("active", false)
//                .put("version", VersionInfo.getVersion())
//                .build();
//        return new Viewable("/add.ftl", dataModel);
//    }
//
//    @GET
//    @Path("edit")
//    @Produces(MediaType.TEXT_HTML)
//    public Viewable edit(@QueryParam("index") @DefaultValue("-1") int index) throws IOException {
//        List<ServerEntry> servers = model.getServers();
//
//        if (index < 0 || index >= servers.size()) {
//            return null;
//        }
//
//        ServerEntry server = servers.get(index);
//
//        ImmutableMap<Object, Object> dataModel = ImmutableMap.builder()
//                .put("name", server.getName())
//                .put("address", server.getAddress())
//                .put("port", server.getPort())
//                .put("owner", server.getOwner())
//                .put("active", server.isActive())
//                .put("version", VersionInfo.getVersion())
//                .build();
//
//        return new Viewable("/edit.ftl", dataModel);
//    }
//
//
//
//    @POST
//    @Path("add")
//    @Produces(MediaType.TEXT_HTML)
//    public Viewable add(@FormParam("name") String name, @FormParam("address") String address, @FormParam("port") int port,
//            @FormParam("owner") String owner, @FormParam("active") String activeOn, @FormParam("secret") String secret) {
//
//        boolean active = "on".equals(activeOn);
//        logger.info("Requested addition: name: {}, address: {}, port:{}, owner:{}, active:{}", name, address, port, owner, active);
//
//        Result response = model.addServer(name, address, port, owner, active, secret);
//
//        if (response.isSuccess()) {
//            ImmutableMap<Object, Object> dataModel = ImmutableMap.builder()
//                    .put("items", list())
//                    .put("message", response.getMessage())
//                    .put("version", VersionInfo.getVersion())
//                    .build();
//            return new Viewable("/server-list.ftl", dataModel);
//        } else {
//            ImmutableMap<Object, Object> dataModel = ImmutableMap.builder()
//                    .put("name", name)
//                    .put("address", address)
//                    .put("port", port)
//                    .put("owner", owner)
//                    .put("active", active)
//                    .put("error", response.getMessage())
//                    .put("version", VersionInfo.getVersion())
//                    .build();
//            return new Viewable("/add.ftl", dataModel);
//        }
//    }
//
//    @POST
//    @Path("remove")
//    @Produces(MediaType.TEXT_HTML)
//    public Viewable remove(@FormParam("name") String name, @FormParam("address") String address, @FormParam("port") int port,
//            @FormParam("owner") String owner, @FormParam("active") String activeOn, @FormParam("secret") String secret) {
//
//        boolean active = "on".equals(activeOn);
//        Result response = model.removeServer(address, port, secret);
//        if (response.isSuccess()) {
//            ImmutableMap<Object, Object> dataModel = ImmutableMap.builder()
//                    .put("items", list())
//                    .put("message", response.getMessage())
//                    .put("version", VersionInfo.getVersion())
//                    .build();
//            return new Viewable("/server-list.ftl", dataModel);
//        } else {
//            ImmutableMap<Object, Object> dataModel = ImmutableMap.builder()
//                    .put("name", name)
//                    .put("address", address)
//                    .put("port", port)
//                    .put("owner", owner)
//                    .put("active", active)
//                    .put("error", response.getMessage())
//                    .put("version", VersionInfo.getVersion())
//                    .build();
//            return new Viewable("/edit.ftl", dataModel);
//        }
//    }
//
//    @POST
//    @Path("update")
//    @Produces(MediaType.TEXT_HTML)
//    public Viewable update(@FormParam("name") String name, @FormParam("address") String address, @FormParam("port") int port,
//            @FormParam("owner") String owner, @FormParam("active") String activeOn, @FormParam("secret") String secret) {
//
//        boolean active = "on".equals(activeOn);
//        Result response = model.updateServer(name, address, port, owner, active, secret);
//        if (response.isSuccess()) {
//            ImmutableMap<Object, Object> dataModel = ImmutableMap.builder()
//                    .put("items", list())
//                    .put("message", response.getMessage())
//                    .put("version", VersionInfo.getVersion())
//                    .build();
//            return new Viewable("/server-list.ftl", dataModel);
//        } else {
//            ImmutableMap<Object, Object> dataModel = ImmutableMap.builder()
//                    .put("name", name)
//                    .put("address", address)
//                    .put("port", port)
//                    .put("owner", owner)
//                    .put("active", active)
//                    .put("error", response.getMessage())
//                    .put("version", VersionInfo.getVersion())
//                    .build();
//            return new Viewable("/edit.ftl", dataModel);
//        }
//    }
}
