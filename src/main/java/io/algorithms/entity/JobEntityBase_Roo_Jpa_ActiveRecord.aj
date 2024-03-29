// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.algorithms.entity;

import io.algorithms.entity.JobEntityBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect JobEntityBase_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager JobEntityBase.entityManager;
    
    public static final EntityManager JobEntityBase.entityManager() {
        EntityManager em = new JobEntityBase().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long JobEntityBase.countJobEntityBases() {
        return entityManager().createQuery("SELECT COUNT(o) FROM JobEntityBase o", Long.class).getSingleResult();
    }
    
    public static List<JobEntityBase> JobEntityBase.findAllJobEntityBases() {
        return entityManager().createQuery("SELECT o FROM JobEntityBase o", JobEntityBase.class).getResultList();
    }
    
    public static JobEntityBase JobEntityBase.findJobEntityBase(Long id) {
        if (id == null) return null;
        return entityManager().find(JobEntityBase.class, id);
    }
    
    public static List<JobEntityBase> JobEntityBase.findJobEntityBaseEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM JobEntityBase o", JobEntityBase.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void JobEntityBase.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void JobEntityBase.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            JobEntityBase attached = JobEntityBase.findJobEntityBase(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void JobEntityBase.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void JobEntityBase.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public JobEntityBase JobEntityBase.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        JobEntityBase merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
