package org.terasology.web.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.terasology.web.core.Module;

public class TeraModuleDAO extends AbstractDAO<Module> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public TeraModuleDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}