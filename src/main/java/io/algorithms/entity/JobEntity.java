/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

import java.util.Date;

/**
 * Represents a job.
 */
public interface JobEntity {
    // The following were originally part of entity
    Long getId();
    
    void setId(Long id);

    String getName();
    
    void setName(String name);
    
    Date getCreateTime();
    
    void setCreateTime(Date createTime);
    
    Date getLastModifiedTime();
    
    void setLastModifiedTime(Date lastModifiedTime);

    // There should be a user here but the DB doesn't have it
//    UserEntity getOwner();
//    
//    void setOwner(UserEntity owner);
    // End entity methods

    JobStatus getStatus();

    void setStatus(JobStatus status);

}