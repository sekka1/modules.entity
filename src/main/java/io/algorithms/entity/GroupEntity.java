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

    List<EntityBase> getChildren();

    void setChildren(List<EntityBase> children);

    void addChild(EntityBase child);

    void addChildren(List<EntityBase> children);

    void removeChild(EntityBase child);

    void removeChildren(List<EntityBase> children);

    void removeAll();

}