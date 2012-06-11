/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: May 5, 2012$
*/
package io.algorithms.entity;

/**
 * Runtime Exception thrown during algorithm execution.
 */
public class AlgorithmNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public AlgorithmNotFoundException() {
        super();
    }

    public AlgorithmNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlgorithmNotFoundException(String message) {
        super(message);
    }

    public AlgorithmNotFoundException(Throwable cause) {
        super(cause);
    }
}
