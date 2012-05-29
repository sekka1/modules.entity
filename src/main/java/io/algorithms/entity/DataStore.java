/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: Feb 22, 2012$
*/
package io.algorithms.entity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface to abstract different stores.
 */
public interface DataStore {
    /**
     * Puts a file into a store.
     * @param id
     * @param inputStream
     */
    InputStream getInputStream(String folder, String fileName) throws IOException;
    
    /**
     * Gets the output stream corresponding to a dataset id.
     * @param id
     * @return
     */
    OutputStream getOutputStream(String folder, String file) throws IOException;

    /**
     * Gets the output stream corresponding to a dataset id.
     * @param folder folder
     * @return contents
     */
    File getFile(String folder, String fileName) throws IOException;

    /**
     * Puts a file into a store.
     * @param folder folder
     * @param fileName fileName
     * @param file contents
     */
    void putFile(String folder, String fileName, File file) throws IOException;
    
}
