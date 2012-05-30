/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: Apr 16, 2012$
*/
package io.algorithms.datastore.amazon;

import io.algorithms.datastore.DataStore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

/**
 * DataStore implementation for Amazon.
 */
public class AmazonDataStore implements DataStore {
    
    private AmazonS3 s3Client;
 
    public AmazonDataStore(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.datastore.DataStore#put(java.lang.Long, io.algorithms.datastore.InputStream)
     */
    @Override
    public void putStream(String folder, String fileName, InputStream inputStream) throws IOException {
        try {
            s3Client.putObject(new PutObjectRequest(folder, fileName, inputStream, new ObjectMetadata()));
        } catch (AmazonClientException e) {
            throw new IOException(e);
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.datastore.DataStore#get(java.lang.Long)
     */
    @Override
    public InputStream getStream(String folder, String fileName) throws IOException {
        S3Object object;
        try {
            return (folder == null || fileName == null) ? null
                    : (object = s3Client.getObject(folder, fileName)) == null ? null
                            : object.getObjectContent();
        } catch (AmazonClientException e) {
            throw new IOException(e);
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.datastore.DataStore#putFile(java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public void putFile(String folder, String fileName, File file)
            throws IOException {
        try {
            s3Client.putObject(new PutObjectRequest(folder, fileName, file));
        } catch (AmazonClientException e) {
            throw new IOException(e);
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.datastore.DataStore#getFile(java.lang.String, java.lang.String)
     */
    @Override
    public File getFile(String folder, String fileName) throws IOException {
        InputStream in = getStream(folder, fileName);
        File f = new File(UUID.randomUUID().toString());
        OutputStream out = new FileOutputStream(f);
        try {
            byte[] buf = new byte[1024];
            while (in.read(buf) > 0) {
                out.write(buf);
            }
        } finally {
            try { if (in != null) { in.close(); } }
            finally { if (out != null) { out.close(); } }
        }
        return f;
    }

}
