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

    public Long getId();
    
    public void setId(Long id);

    public String getName();
    
    public void setName(String name);
    
    public String getDescription();
    
    public void setDescription(String description);
    
    public Date getCreateTime();
    
    public void setCreateTime(Date createTime);
    
    public Date getLastModifiedTime();
    
    public void setLastModifiedTime(Date lastModifiedTime);
    
    public String getUri();
    
    public void setUri(String uri);
    
    public UserEntity getOwner();
    
    public void setOwner(UserEntity owner);
    
    public GroupEntity getOwnerGroup();
    
    public void setOwnerGroup(GroupEntity ownerGroup);
    
    public void setParentGroup(GroupEntity group);

    public GroupEntity getParentGroup();

    public UserEntity getLastModifiedUser();
    
    public void setLastModifiedUser(UserEntity lastModifiedUser);
    
    public Set<Permission> getOwnerPermissions();
    
    public void setOwnerPermissions(Set<Permission> ownerPermissions);
    
    public Set<Permission> getOwnerGroupPermissions();
    
    public void setOwnerGroupPermissions(Set<Permission> ownerGroupPermissions);
    
    public Set<Permission> getOthersPermissions();
    
    public void setOthersPermissions(Set<Permission> othersPermissions);

}
