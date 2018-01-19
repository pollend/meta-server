package org.terasology.web.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.terasology.web.core.TeraServer;

import java.util.List;

public class TeraServerDAO extends AbstractDAO<TeraServer> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public TeraServerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public TeraServer create(TeraServer server) {
        return persist(server);
    }


    public TeraServer findById(Long id) {
        return get(id);
    }

    public List findAll() {
        return list(namedQuery("org.terasology.web.core.TeraServer.findAll"));
    }

}
