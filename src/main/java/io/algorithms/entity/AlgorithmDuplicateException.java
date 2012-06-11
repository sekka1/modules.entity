/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: May 5, 2012$
*/
package io.algorithms.entity;

/**
 * Runtime Exception thrown during algorithm execution.
 */
public class AlgorithmDuplicateException extends Exception {

    private static final long serialVersionUID = 1L;

    public AlgorithmDuplicateException() {
        super();
    }

    public AlgorithmDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlgorithmDuplicateException(String message) {
        super(message);
    }

    public AlgorithmDuplicateException(Throwable cause) {
        super(cause);
    }
}
