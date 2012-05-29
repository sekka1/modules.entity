// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.algorithms.entity;

import io.algorithms.entity.FieldEntityBase;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect FieldEntity_Roo_Jpa_ActiveRecord {
    
    public static long FieldEntityBase.countFieldEntitys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM FieldEntity o", Long.class).getSingleResult();
    }
    
    public static List<FieldEntityBase> FieldEntityBase.findAllFieldEntitys() {
        return entityManager().createQuery("SELECT o FROM FieldEntity o", FieldEntityBase.class).getResultList();
    }
    
    public static FieldEntityBase FieldEntityBase.findFieldEntity(Long id) {
        if (id == null) return null;
        return entityManager().find(FieldEntityBase.class, id);
    }
    
    public static List<FieldEntityBase> FieldEntityBase.findFieldEntityEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM FieldEntity o", FieldEntityBase.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public FieldEntityBase FieldEntityBase.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        FieldEntityBase merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
