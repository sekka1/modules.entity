/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: May 5, 2012$
*/
package io.algorithms.datastore;

/**
 * Runtime Exception thrown during algorithm execution.
 */
public class DataStoreNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataStoreNotFoundException() {
        super();
    }

    public DataStoreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataStoreNotFoundException(String message) {
        super(message);
    }

    public DataStoreNotFoundException(Throwable cause) {
        super(cause);
    }
}
