// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.algorithms.entity;

import io.algorithms.entity.Entity;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

privileged aspect Entity_Roo_Jpa_Entity {
    
    declare @type: Entity: @javax.persistence.Entity;
    
    declare @type: Entity: @Inheritance(strategy = InheritanceType.JOINED);
    
    @Version
    @Column(name = "version")
    private Integer Entity.version;
    
    public Integer Entity.getVersion() {
        return this.version;
    }
    
    public void Entity.setVersion(Integer version) {
        this.version = version;
    }
    
}
