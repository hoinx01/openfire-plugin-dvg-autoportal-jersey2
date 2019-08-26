package vn.dvg.autoportal;

import org.jivesoftware.admin.AuthCheckFilter;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.net.SASLAuthentication;
import vn.dvg.autoportal.sasl.DvgSaslProvider;
import vn.dvg.autoportal.sasl.DvgSaslServer;

import java.io.File;
import java.security.Security;

/**
 * An Openfire plugin that adds the TikiToken SASL mechanism.
 */
public class DvgAutoPortalPlugin implements Plugin
{
    @Override
    public void initializePlugin( PluginManager manager, File pluginDirectory )
    {
        AuthCheckFilter.addExclude("dvg-autoportal/*");
        Security.addProvider( new DvgSaslProvider() );
        SASLAuthentication.addSupportedMechanism( DvgSaslServer.MECHANISM_NAME );
    }

    @Override
    public void destroyPlugin()
    {
        SASLAuthentication.removeSupportedMechanism( DvgSaslServer.MECHANISM_NAME );
        Security.removeProvider( DvgSaslProvider.NAME );
    }
}
