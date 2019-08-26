package vn.dvg.autoportal.restapi;

import org.glassfish.jersey.server.ResourceConfig;
import vn.dvg.autoportal.restapi.controllers.ApplicationController;
import vn.dvg.autoportal.restapi.controllers.UserController;

public class ApplicationResourceConfig extends ResourceConfig {
    public ApplicationResourceConfig() {
        register(new DependencyRegister());
        register(UserController.class);
        register(ApplicationController.class);
//        packages(true, "vn.hoinx.experience");
//        val logger = LoggerFactory.getLogger(ApplicationConfig.class);
//        logger.debug("init ApplicationConfig");
    }
}