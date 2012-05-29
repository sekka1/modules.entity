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

import java.util.List;

/**
 * 
 */
public interface GroupEntity extends Entity {

    public abstract List<EntityBase> getChildren();

    public abstract void setChildren(List<EntityBase> children);

    public abstract void addChild(EntityBase child);

    public abstract void addChildren(List<EntityBase> children);

    public abstract void removeChild(EntityBase child);

    public abstract void removeChildren(List<EntityBase> children);

    public abstract void removeAll();

}