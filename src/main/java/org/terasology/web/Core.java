package org.terasology.web;

import dagger.Component;
import org.terasology.web.dao.DataAccessObjectModule;
import org.terasology.web.db.DataAccessObjectModule;
import org.terasology.web.services.ServiceModule;


@Component(modules = {DataAccessObjectModule.class, ServiceModule.class})
public interface Core {

}
