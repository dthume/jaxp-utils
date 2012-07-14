package org.dthume.jaxp;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;

public class ChainingURIResolver implements URIResolver {
    private final List<URIResolver> resolvers;
    
    public ChainingURIResolver(final URIResolver...resolvers) {
        this(java.util.Arrays.asList(resolvers));
    }
    
    public ChainingURIResolver(final Collection<URIResolver> resolvers) {
        this.resolvers = new LinkedList<URIResolver>(resolvers);
    }
    
    public Source resolve(final String href, final String base)
            throws TransformerException {
        Source source = null;
        for (final URIResolver resolver : resolvers)
            if (null != (source = resolver.resolve(href, base)))
                break;
        return source;
    }
}
