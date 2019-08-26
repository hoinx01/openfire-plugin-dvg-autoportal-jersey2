package vn.dvg.autoportal.restapi;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.WebConfig;

import javax.servlet.ServletException;

public class RestApiServletContainer extends ServletContainer {
    public RestApiServletContainer(ResourceConfig resourceConfig){

        super(resourceConfig);
    }
    public RestApiServletContainer(){
        super(new ApplicationResourceConfig());
    }
    @Override
    protected void init(WebConfig webConfig) throws ServletException {
        super.init(webConfig);
    }
}
