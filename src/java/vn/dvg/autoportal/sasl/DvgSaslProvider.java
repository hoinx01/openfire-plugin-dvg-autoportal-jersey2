package vn.dvg.autoportal.sasl;

import java.security.Provider;

/**
 * A Provider implementation for a SASL mechanism that uses a Tiki token.
 *
 * This implementation makes use of a Tiki server for token validation.
 *
 * @see <a href="https://tools.ietf.org/html/rfc7628">RFC 7628</a>
 */
public class DvgSaslProvider extends Provider
{
    /**
     * The provider name.
     */
    public static final String NAME = "DvgSasl";

    /**
     * The provider version number.
     */
    public static final double VERSION = 1.0;

    /**
     * A description of the provider and its services.
     */
    public static final String INFO = "Provides a SASL mechanism that uses a Tiki instance to verify authentication tokens.";

    public DvgSaslProvider()
    {
        super( NAME, VERSION, INFO );

        put( "SaslServerFactory." + DvgSaslServer.MECHANISM_NAME, DvgSaslServerFactory.class.getCanonicalName() );
    }
}
