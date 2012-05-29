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

import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord(table = "group_table")
@XmlRootElement
public class GroupEntityBase extends EntityBase implements GroupEntity {
    @ElementCollection(targetClass=EntityBase.class, fetch=FetchType.LAZY)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    @JoinTable(joinColumns=@JoinColumn(name="group_id"))
    @XmlTransient
    private List<EntityBase> children = new ArrayList<EntityBase>();

    /* (non-Javadoc)
     * @see io.algorithms.entity.GroupEntityI#getChildren()
     */
    @Override
    public List<EntityBase> getChildren() {
        return this.children;
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.GroupEntityI#setChildren(java.util.List)
     */
    @Override
    public void setChildren(List<EntityBase> children) {
        synchronized(this) {
            removeAll();
            addChildren(children);
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.GroupEntityI#addChild(io.algorithms.entity.EntityBase)
     */
    @Override
    public void addChild(EntityBase child) {
        if (child != null) {
            addChildren(Collections.singletonList(child));
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.GroupEntityI#addChildren(java.util.List)
     */
    @Override
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

    /* (non-Javadoc)
     * @see io.algorithms.entity.GroupEntityI#removeChild(io.algorithms.entity.EntityBase)
     */
    @Override
    public void removeChild(EntityBase child) {
        if (child != null) {
            removeChildren(Collections.singletonList(child));
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.GroupEntityI#removeChildren(java.util.List)
     */
    @Override
    public void removeChildren(List<EntityBase> children) {
        if (children != null && children.size() > 0) {
            synchronized (this) {
                this.children.removeAll(children);
            }
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.GroupEntityI#removeAll()
     */
    @Override
    public void removeAll() {
        removeChildren(children);
    }
}
