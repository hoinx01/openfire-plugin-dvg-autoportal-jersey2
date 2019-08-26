package vn.dvg.autoportal.restapi.services.impl;

import org.jvnet.hk2.annotations.Service;
import vn.dvg.autoportal.restapi.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    public String test(){
       return "haha";
    }
}
