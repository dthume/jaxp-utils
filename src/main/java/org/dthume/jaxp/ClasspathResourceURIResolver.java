package org.dthume.jaxp;

import java.io.InputStream;
import java.net.URI;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;

public class ClasspathResourceURIResolver extends AbstractAbsoluteURIResolver {
    private final ClassLoader classLoader;
    
    public ClasspathResourceURIResolver(final Class<?> clazz) {
        this(clazz.getClassLoader());
    }
    
    public ClasspathResourceURIResolver(final ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public Source resolve(final URI uri) throws TransformerException {
        if (!"resource".equals(uri.getScheme()))
            return null;
        
        final String path = uri.getSchemeSpecificPart();
        final InputStream in = classLoader.getResourceAsStream(path);
        
        return new StreamSource(in, uri.toString());
    }

}
