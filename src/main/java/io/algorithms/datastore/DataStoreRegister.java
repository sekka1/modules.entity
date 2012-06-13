/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.datastore;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

/**
 * Translates between implementation class string and actual implemenation.
 */
public class DataStoreRegister {

    private static ConcurrentMap<String, DataStore> dataStoreRegister = new ConcurrentHashMap<String, DataStore>();
    
    static {
        // TODO: This is test code. Please remove!
        DataStore s3dataStore = new AmazonDataStore(new AmazonS3Client(new BasicAWSCredentials("AKIAJO6OOIFG3LCMZPGA", "sQNUF++7eFhh8JIlTNgUnKKx3HdOhRmN+V7pto5F")));
        dataStoreRegister.put("S3,algorithms.io", s3dataStore);
    }
    
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
