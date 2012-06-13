/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: May 5, 2012$
*/
package io.algorithms.datastore;

/**
 * Runtime Exception thrown during algorithm execution.
 */
public class DataStoreDuplicateException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataStoreDuplicateException() {
        super();
    }

    public DataStoreDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataStoreDuplicateException(String message) {
        super(message);
    }

    public DataStoreDuplicateException(Throwable cause) {
        super(cause);
    }
}
