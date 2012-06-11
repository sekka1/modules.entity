/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Interface for dataset.
 */
public interface DataSetEntity {
    // The following were originally part of entity
    Long getId();
    
    void setId(Long id);

    String getName();
    
    void setName(String name);
    
    String getDescription();
    
    void setDescription(String description);
    
    Date getCreateTime();
    
    void setCreateTime(Date createTime);
    
    Date getLastModifiedTime();
    
    void setLastModifiedTime(Date lastModifiedTime);
    
    UserEntity getOwner();
    
    void setOwner(UserEntityBase owner);
    // End entity methods

    long getSize();

    void setSize(long size);
    
    File getDataFile();
    
    void putDataFile(File file);
    
    InputStream getDataInputStream();
    
    OutputStream getDataOutputStream();
}