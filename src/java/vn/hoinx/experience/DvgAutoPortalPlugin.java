package vn.hoinx.experience;

import org.jivesoftware.admin.AuthCheckFilter;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.net.SASLAuthentication;
import org.jivesoftware.util.JiveGlobals;
import vn.hoinx.experience.authentication.DvgSaslProvider;
import vn.hoinx.experience.authentication.DvgSaslServer;

import java.io.File;
import java.security.Security;
import java.util.Collection;

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
