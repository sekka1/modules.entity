/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

import java.util.Set;

/**
 * Represents a user
 */
public interface UserEntity extends Entity {

    public abstract Set<GroupEntityBase> getGroups();

    public abstract void setGroups(Set<GroupEntityBase> groups);

    public abstract Set<String> getAuthTokens();

    public abstract void setAuthTokens(Set<String> authTokens);

}