/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Translates between implementation class string and actual implemenation.
 */
public class AlgorithmRegister {

    private static ConcurrentMap<String, Algorithm> algorithmRegister = new ConcurrentHashMap<String, Algorithm>();
    
    /**
     * @param implementation
     * @return
     */
    public static Algorithm getAlgorithm(String implementation) throws AlgorithmNotFoundException {
        return algorithmRegister.get(implementation);
    }

    /**
     * @param implementationClass
     * @param algorithm
     */
    public static void registerAlgorithm(String implementationClass, Algorithm algorithm) throws AlgorithmDuplicateException, AlgorithmException {
        if (implementationClass == null || algorithm == null) {
            throw new AlgorithmException("Cannot register null algorithm with key [" + implementationClass + "] and algorithm [" + algorithm + "]");
        }

        Algorithm old = algorithmRegister.putIfAbsent(implementationClass, algorithm);
        
        if (old != null) {
            throw new AlgorithmDuplicateException("Duplicate algorithm [" + implementationClass + "]");
        }
    }

}
