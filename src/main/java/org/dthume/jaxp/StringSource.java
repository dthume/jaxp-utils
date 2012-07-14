package org.dthume.jaxp;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.transform.stream.StreamSource;

public class StringSource extends StreamSource {
    private final String xml;
    
    public StringSource(final String xml) {
        this.xml = xml;
    }

    @Override
    public Reader getReader() { return new StringReader(xml); }

    @Override
    public void setInputStream(final InputStream inputStream) {
        throw new UnsupportedOperationException("Cannot set inputStream");
    }

    @Override
    public void setReader(final Reader reader) {
        throw new UnsupportedOperationException("Cannot change reader");
    }
}
