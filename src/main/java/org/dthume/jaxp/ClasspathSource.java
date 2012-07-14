package org.dthume.jaxp;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import javax.xml.transform.stream.StreamSource;

public class ClasspathSource extends StreamSource {
    private final Class<?> clazz;
    private final String url;
    
    public ClasspathSource(final String url) {
        this(url, ClasspathSource.class);
    }
    
    public ClasspathSource(final String url, final Class<?> clazz) {
        this.url = url;
        this.clazz = clazz;
    }

    @Override
    public InputStream getInputStream() {
        return clazz.getResourceAsStream(url);
    }
    
    @Override
    public String getSystemId() { return clazz.getResource(url).toString(); }
    
    @Override
    public void setInputStream(final InputStream inputStream) {
        throw new UnsupportedOperationException("Cannot change inputStream");
    }

    @Override
    public void setReader(final Reader reader) {
        throw new UnsupportedOperationException("Cannot set reader");
    }

    @Override
    public void setSystemId(final File f) {
        throw new UnsupportedOperationException("Cannot set systemId");
    }

    @Override
    public void setSystemId(final String systemId) {
        throw new UnsupportedOperationException("Cannot set systemId");
    }
}
