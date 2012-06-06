/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

import java.util.Date;
import java.util.Set;

/**
 * Entity interface.
 */
public interface Entity {

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
    
    String getUri();
    
    void setUri(String uri);
    
    UserEntity getOwner();
    
    void setOwner(UserEntity owner);
    
    GroupEntity getOwnerGroup();
    
    void setOwnerGroup(GroupEntity ownerGroup);
    
    void setParentGroup(GroupEntity group);

    GroupEntity getParentGroup();

    UserEntity getLastModifiedUser();
    
    void setLastModifiedUser(UserEntity lastModifiedUser);
    
    Set<Permission> getOwnerPermissions();
    
    void setOwnerPermissions(Set<Permission> ownerPermissions);
    
    Set<Permission> getOwnerGroupPermissions();
    
    void setOwnerGroupPermissions(Set<Permission> ownerGroupPermissions);
    
    Set<Permission> getOthersPermissions();
    
    void setOthersPermissions(Set<Permission> othersPermissions);

}
