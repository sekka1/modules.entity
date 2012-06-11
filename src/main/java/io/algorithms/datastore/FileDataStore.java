/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: Apr 16, 2012$
*/
package io.algorithms.datastore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * DataStore implementation that uses local files for storage.
 */
public class FileDataStore implements DataStore {

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.DataStore#getInputStream(java.lang.String, java.lang.String)
     */
    @Override
    public InputStream getInputStream(String folder, String fileName)
            throws IOException {
        return new FileInputStream(new File(folder, fileName));
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.DataStore#getOutputStream(java.lang.String, java.lang.String)
     */
    @Override
    public OutputStream getOutputStream(String folder, String fileName)
            throws IOException {
        return new FileOutputStream(new File(folder, fileName));
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.DataStore#getFile(java.lang.String, java.lang.String)
     */
    @Override
    public File getFile(String folder, String fileName) throws IOException {
        return new File(folder, fileName);
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.DataStore#putFile(java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public void putFile(String folder, String fileName, File file)
            throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(new File(folder, fileName));
            byte[] buffer = new byte[2048];
            while (inputStream.read(buffer) > 0) {
                outputStream.write(buffer);
            }
        } finally {
            try {
                if (inputStream != null) { inputStream.close(); }
            } finally {
                if (outputStream != null) { outputStream.close(); }
            }
        }
    }

}
