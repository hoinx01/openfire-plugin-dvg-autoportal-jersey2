package vn.hoinx.experience;

import lombok.val;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.LoggerFactory;
import vn.hoinx.experience.controllers.UserController;

public class ApplicationConfig  extends ResourceConfig {
    public ApplicationConfig() {
        register(new ApplicationBinder());
        register(UserController.class);
//        packages(true, "vn.hoinx.experience");
//        val logger = LoggerFactory.getLogger(ApplicationConfig.class);
//        logger.debug("init ApplicationConfig");
    }
}