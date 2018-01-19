package org.terasology.web.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.terasology.web.core.TeraModule;

public class TeraModuleDAO extends AbstractDAO<TeraModule> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public TeraModuleDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
