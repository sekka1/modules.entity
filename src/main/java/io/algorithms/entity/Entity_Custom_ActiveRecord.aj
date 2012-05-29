/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: Feb 22, 2012$
*/
package io.algorithms.entity;

import io.algorithms.entity.EntityBase;

privileged aspect Entity_Custom_ActiveRecord {
    
    /**
     * When an entity is persisted
     * @param entity
     */
    pointcut persist(EntityBase entity):
        execution(public void EntityBase.persist())
        && this(entity);
        
    /**
     * Ensure that parents exist.
     * @param entity
     */
    before(EntityBase entity): persist(entity) {
    }
}
