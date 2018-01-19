package org.terasology.web;

import io.dropwizard.Application;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jersey.protobuf.ProtobufBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.terasology.web.core.User;
import org.terasology.web.db.DataAccessObjectModule;
import org.terasology.web.services.ServiceModule;


public class App extends Application<Config> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    private final HibernateBundle<Config> hibernateBundle = new HibernateBundle<Config>(null) {
        @Override
        public DataSourceFactory getDataSourceFactory(Config configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    private final FlywayBundle<Config> flywayBundle = new FlywayBundle<Config>() {
        @Override
        public DataSourceFactory getDataSourceFactory(Config configuration) {
            return configuration.getDataSourceFactory();
        }

        @Override
        public FlywayFactory getFlywayFactory(Config configuration) {
            return configuration.getFlyway();
        }
    };


    @Override
    public String getName() {
        return "affiliated";
    }


    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
        //add flyway bundle
        bootstrap.addBundle(flywayBundle);
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new MultiPartBundle());
        bootstrap.addBundle(new ProtobufBundle());

        super.initialize(bootstrap);
    }

    @Override
    public void run(Config configuration, Environment environment) throws Exception {
        Core core = DaggerCore.builder()
                .dataAccessObjectModule(new DataAccessObjectModule(hibernateBundle))
                .serviceModule(new ServiceModule(configuration, environment)).build();

//        environment.jersey().register(new BasicCredentialAuthFilter());

        environment.jersey().register(core.moduleResource());
        environment.jersey().register(core.serverResource());

//        environment.jersey().
        //register jersy
//        environment.jersey().register(core.userResource());

//        SimpleModule module = new SimpleModule();
//        final ResourceSerializer resourceSerializer = new ResourceSerializer(Resource.class);
//        resourceSerializer.setFileRepository(configuration.getFileFactory().build());
//        module.addSerializer(Resource.class,resourceSerializer);
//        environment.getObjectMapper().registerModule(module);
//
//        environment.jersey().register(new AuthDynamicFeature(new JWTCredentialAuthFilter.Builder<User>()
//                .setAuthenticator(core.jwtAuth())
//                .setAuthorizer(new AffiliateAuthorize())
//                .setPrefix("Bearer")
//                .buildAuthFilter()));




//        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
//        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
    }
}
