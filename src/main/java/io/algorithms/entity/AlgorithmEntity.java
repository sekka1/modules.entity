/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

import java.util.Date;

/**
 * Algorithm Entity interface.
 */
public interface AlgorithmEntity {
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
    // End entity methods

    String getCategory();

    void setCategory(String categories);
    
    Algorithm getAlgorithm();

    void setAlgorithm(Algorithm algorithm);
    
}