// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.algorithms.entity;

import io.algorithms.entity.EntityBase;
import io.algorithms.entity.GroupEntity;
import java.util.List;

privileged aspect GroupEntity_Roo_JavaBean {
    
    public List<EntityBase> GroupEntity.getChildren() {
        return this.children;
    }
    
}