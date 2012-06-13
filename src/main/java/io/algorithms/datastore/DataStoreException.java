/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: May 5, 2012$
*/
package io.algorithms.datastore;

/**
 * Runtime Exception thrown during algorithm execution.
 */
public class DataStoreException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataStoreException() {
        super();
    }

    public DataStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataStoreException(String message) {
        super(message);
    }

    public DataStoreException(Throwable cause) {
        super(cause);
    }
}
