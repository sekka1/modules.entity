// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.algorithms.entity;

import io.algorithms.entity.AlgorithmEntityBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AlgorithmEntityBase_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager AlgorithmEntityBase.entityManager;
    
    public static final EntityManager AlgorithmEntityBase.entityManager() {
        EntityManager em = new AlgorithmEntityBase().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long AlgorithmEntityBase.countAlgorithmEntityBases() {
        return entityManager().createQuery("SELECT COUNT(o) FROM AlgorithmEntityBase o", Long.class).getSingleResult();
    }
    
    public static List<AlgorithmEntityBase> AlgorithmEntityBase.findAllAlgorithmEntityBases() {
        return entityManager().createQuery("SELECT o FROM AlgorithmEntityBase o", AlgorithmEntityBase.class).getResultList();
    }
    
    public static AlgorithmEntityBase AlgorithmEntityBase.findAlgorithmEntityBase(Long id) {
        if (id == null) return null;
        return entityManager().find(AlgorithmEntityBase.class, id);
    }
    
    public static List<AlgorithmEntityBase> AlgorithmEntityBase.findAlgorithmEntityBaseEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM AlgorithmEntityBase o", AlgorithmEntityBase.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void AlgorithmEntityBase.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void AlgorithmEntityBase.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            AlgorithmEntityBase attached = AlgorithmEntityBase.findAlgorithmEntityBase(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void AlgorithmEntityBase.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void AlgorithmEntityBase.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public AlgorithmEntityBase AlgorithmEntityBase.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        AlgorithmEntityBase merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
