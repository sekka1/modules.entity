/*
 * Copyright 2001-2012 ArcSight, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of ArcSight, Inc.
 * Use is subject to license terms.
 *
 * $Author: rajiv$
 * $Date: May 29, 2012$
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