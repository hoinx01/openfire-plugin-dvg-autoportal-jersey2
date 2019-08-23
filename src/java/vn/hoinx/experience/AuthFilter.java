package vn.hoinx.experience;


import org.glassfish.jersey.server.ContainerRequest;
import org.jivesoftware.openfire.auth.AuthFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.Console;
import java.io.IOException;

/**
 * The Class AuthFilter.
 */
@Provider
public class AuthFilter implements ContainerRequestFilter {
    /** The log. */
//    private static Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

    /** The http request. */
    @Context
    private HttpServletRequest httpRequest;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
//        LOG.debug("receive request: " + httpRequest.getRequestURI());
        System.out.println("receive request: " + httpRequest.getRequestURI());
//        containerRequestContext
    }
}
