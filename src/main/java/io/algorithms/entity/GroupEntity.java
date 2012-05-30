/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
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