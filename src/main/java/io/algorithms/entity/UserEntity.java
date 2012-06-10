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

    Set<GroupEntityBase> getGroups();

    void setGroups(Set<GroupEntityBase> groups);

    Set<String> getAuthTokens();

    void setAuthTokens(Set<String> authTokens);

}