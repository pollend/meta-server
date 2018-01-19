package org.terasology.web;

import dagger.Component;
import org.terasology.web.db.DataAccessObjectModule;
import org.terasology.web.resources.ModuleResource;
import org.terasology.web.resources.ServerResource;
import org.terasology.web.services.ServiceModule;


@Component(modules = {DataAccessObjectModule.class, ServiceModule.class})
public interface Core {
    ModuleResource moduleResource();
    ServerResource serverResource();
}
