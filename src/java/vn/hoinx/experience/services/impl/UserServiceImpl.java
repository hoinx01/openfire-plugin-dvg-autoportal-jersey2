package vn.hoinx.experience.services.impl;

import org.jvnet.hk2.annotations.Service;
import vn.hoinx.experience.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    public String test(){
       return "haha";
    }
}
