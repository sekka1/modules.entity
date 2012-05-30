/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: Feb 22, 2012$
*/
package io.algorithms.entity;

import io.algorithms.entity.Entity;

privileged aspect Entity_Custom_ActiveRecord {
    /**
     * Find entity by URI.
     * @param type
     * @param uri
     * @return
     */
    public static <T extends Entity> T Entity.findByURI(Class<T> type, String uri) {
        try {
            return type.cast(Entity.entityManager().createQuery("SELECT o FROM " + type.getName() + " o where uri = :uri").setParameter("uri", uri).getSingleResult());
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * When an entity is persisted
     * @param entity
     */
    pointcut persist(Entity entity):
        execution(public void Entity.persist())
        && this(entity);
        
    /**
     * Ensure that parents exist.
     * @param entity
     */
    before(Entity entity): persist(entity) {
    }
}
