package com.dynacrongroup.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleKnownRunTimeException extends RuntimeException {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleKnownRunTimeException.class);

    public SimpleKnownRunTimeException(String s) {
        LOG.error("Exception thrown: {}", s);
    }
}
