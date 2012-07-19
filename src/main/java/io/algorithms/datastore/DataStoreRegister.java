/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.datastore;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Translates between implementation class string and actual implemenation.
 */
public class DataStoreRegister {

    private static ConcurrentMap<String, DataStore> dataStoreRegister = new ConcurrentHashMap<String, DataStore>();
    
    /**
     * @param implementation
     * @return
     */
    public static DataStore getDataStore(String location) throws DataStoreNotFoundException {
        return dataStoreRegister.get(location);
    }

    /**
     * @param implementationClass
     * @param algorithm
     */
    public static void registerDataStore(String location, DataStore dataStore) throws DataStoreDuplicateException, DataStoreException {
        if (location == null || dataStore == null) {
            throw new DataStoreException("Cannot register null dataStore with key [" + location + "] and algorithm [" + dataStore + "]");
        }

        DataStore old = dataStoreRegister.putIfAbsent(location, dataStore);
        
        if (old != null) {
            throw new DataStoreDuplicateException("Duplicate dataStore [" + location + "]");
        }
    }

}
