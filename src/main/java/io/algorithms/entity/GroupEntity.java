package io.algorithms.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "group_table")
@XmlRootElement
public class GroupEntity extends EntityBase {
    @ElementCollection(targetClass=EntityBase.class, fetch=FetchType.LAZY)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    @JoinTable(joinColumns=@JoinColumn(name="group_id"))
    @XmlTransient
    private List<EntityBase> children = new ArrayList<EntityBase>();

    
    public void setChildren(List<EntityBase> children) {
        synchronized(this) {
            removeAll();
            addChildren(children);
        }
    }

    public void addChild(EntityBase child) {
        if (child != null) {
            addChildren(Collections.singletonList(child));
        }
    }

    public void addChildren(List<EntityBase> children) {
        if (children != null && children.size() > 0) {
            synchronized(this) {
                this.children.addAll(children);
                for (EntityBase child: this.children) {
                    if (child.getParentGroup() == null || !child.getParentGroup().equals(this)) {
                        child.setParentGroup(this);
                    }
                }
            }
        }
    }

    public void removeChild(EntityBase child) {
        if (child != null) {
            removeChildren(Collections.singletonList(child));
        }
    }

    public void removeChildren(List<EntityBase> children) {
        if (children != null && children.size() > 0) {
            synchronized (this) {
                this.children.removeAll(children);
            }
        }
    }

    public void removeAll() {
        removeChildren(children);
    }
}
