package vn.dvg.autoportal.restapi.filters;


import lombok.val;
import org.glassfish.jersey.server.ContainerRequest;
import org.jivesoftware.openfire.auth.AuthFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.dvg.autoportal.restapi.authentication.CustomSecurityContext;
import vn.dvg.autoportal.restapi.authentication.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.Console;
import java.io.IOException;

/**
 * The Class AuthFilter.
 */
@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
    /** The log. */
//    private static Logger LOG = LoggerFactory.getLogger(AuthFilter.class);
    private static final String AUTHENTICATION_SCHEME = "Bearer";
    private static final String REALM = "dvg-autoportal";
    /** The http request. */
    @Context
    private HttpServletRequest httpRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (!isTokenBasedAuthentication(authorizationHeader)) {
            return;
        }
        // (3) Extract the token from the Authorization header
        String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();
        
//        LOG.debug("receive request: " + httpRequest.getRequestURI());
        System.out.println("receive request: " + httpRequest.getRequestURI());
//        containerRequestContext

        try {

            // (4) Validate the token
            if (JwtUtils.isTokenExpired(token)) {
                abortWithUnauthorized(requestContext);
                return;
            }

            // (5) Getting the User information from token
            val user = JwtUtils.getUserFromToken(token);

            // (6) Overriding the security context of the current request
            SecurityContext originalSecurityContext = requestContext.getSecurityContext();

            requestContext.setSecurityContext(new CustomSecurityContext(user, originalSecurityContext.isSecure()));
        } catch (Exception e) {
            abortWithUnauthorized(requestContext);
        }
    }
    private boolean isTokenBasedAuthentication(String authorizationHeader) {

        // Check if the Authorization header is valid
        // It must not be null and must be prefixed with "Bearer" plus a whitespace
        // The authentication scheme comparison must be case-insensitive
        return authorizationHeader != null
                && authorizationHeader.toLowerCase().startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }
    private void abortWithUnauthorized(ContainerRequestContext requestContext) {

        // Abort the filter chain with a 401 status code response
        // The WWW-Authenticate header is sent along with the response
        Response respone = Response.status(Response.Status.UNAUTHORIZED) // 401 Unauthorized
                .header(HttpHeaders.WWW_AUTHENTICATE, AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
                .entity("You cannot access this resource") // the response entity
                .build();
        requestContext.abortWith(respone);
    }
}
