package org.dthume.jaxp;

import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;

public abstract class AbstractAbsoluteURIResolver implements URIResolver {
    public Source resolve(final String href, final String base)
            throws TransformerException {
        final URI uri = resolveURI(href, base);
        return null == uri ? null : resolve(uri);
    }
    
    private URI resolveURI(final String href, final String base) {
        try {
            return isEmpty(base) ? new URI(href) : new URI(base).resolve(href);
        } catch (final URISyntaxException e) {
            return null;
        }
    }
    
    private boolean isEmpty(final String s) {
        return null == s || 0 == s.length() || "".equals(s);
    }
    
    protected abstract Source resolve(URI uri) throws TransformerException;
}
