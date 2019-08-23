package vn.hoinx.experience;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import vn.hoinx.experience.services.UserService;
import vn.hoinx.experience.services.impl.UserServiceImpl;

import javax.inject.Singleton;

public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(UserServiceImpl.class).to(UserService.class).in(Singleton.class);
    }
}