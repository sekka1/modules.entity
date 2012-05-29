/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: Feb 22, 2012$
*/
package io.algorithms.entity;

import io.algorithms.entity.EntityBase;

privileged aspect Entity_Custom_ActiveRecord {
    /**
     * Find entity by URI.
     * @param type
     * @param uri
     * @return
     */
    public static <T extends EntityBase> T EntityBase.findByURI(Class<T> type, String uri) {
        try {
            return type.cast(EntityBase.entityManager().createQuery("SELECT o FROM " + type.getName() + " o where uri = :uri").setParameter("uri", uri).getSingleResult());
        } catch (Exception e) {
            return null;
        }
    }
    
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
