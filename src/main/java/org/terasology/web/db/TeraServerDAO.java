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

    public List<TeraServer> findAll() {
        return list(namedQuery("org.terasology.web.core.TeraServer.findAll"));
    }


    public void delete(TeraServer person) {
        currentSession().delete(person);
    }

    public void update(TeraServer person) {
        currentSession().saveOrUpdate(person);
    }

    public TeraServer insert(TeraServer person) {
        return persist(person);
    }
}
