package vn.dvg.autoportal.restapi.authentication;

import vn.dvg.autoportal.restapi.statics.UserType;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class CustomSecurityContext implements SecurityContext {

    private ApplicationUser user;
    private boolean secure;

    public CustomSecurityContext(ApplicationUser user, boolean secure) {
        this.user = user;
        this.secure = secure;
    }

    @Override
    public Principal getUserPrincipal() {
        return () -> user.getId();
    }

    @Override
    public boolean isUserInRole(String roleName) {
        if(roleName.equals(ApplicationRole.APPLICATION.getName()))
            return user.getType().equals(UserType.APPLICATION.getName());
        else if(roleName.equals(ApplicationRole.CHAT_PARTICIPANT.getName()))
            return user.getType().equals(UserType.CHAT_PARTICIPANT.getName());
        return false;
    }

    @Override
    public boolean isSecure() {
        return secure;
    }

    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}
