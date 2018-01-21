package org.terasology.web.db;

import dagger.Module;
import dagger.Provides;
import io.dropwizard.hibernate.HibernateBundle;
import org.terasology.web.Config;

@Module
public class DataAccessObjectModule {
    private final HibernateBundle<Config> hibernate;

    public DataAccessObjectModule(HibernateBundle<Config> hibernate) {
        this.hibernate = hibernate;
    }

    @Provides
    public TeraServerDAO providerServerDAO(){
        return new TeraServerDAO(hibernate.getSessionFactory());
    }

}
