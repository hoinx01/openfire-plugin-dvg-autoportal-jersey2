package vn.dvg.autoportal.restapi;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import vn.dvg.autoportal.data.dao.ApplicationDao;
import vn.dvg.autoportal.data.dao.UserDao;
import vn.dvg.autoportal.data.dao.impl.ApplicationDaoImpl;
import vn.dvg.autoportal.data.dao.impl.UserDaoImpl;
import vn.dvg.autoportal.restapi.services.UserService;
import vn.dvg.autoportal.restapi.services.impl.UserServiceImpl;

import javax.inject.Singleton;

public class DependencyRegister extends AbstractBinder {
    @Override
    protected void configure() {
        bind(ApplicationDaoImpl.class).to(ApplicationDao.class).in(Singleton.class);
        bind(UserDaoImpl.class).to(UserDao.class).in(Singleton.class);
        bind(UserServiceImpl.class).to(UserService.class).in(Singleton.class);
    }
}