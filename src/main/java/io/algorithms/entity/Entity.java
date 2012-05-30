package io.algorithms.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import static io.algorithms.common.Constants.*;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierField = "id", inheritanceType = "JOINED")
public abstract class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;
    
    private String name;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date createTime, lastModifiedTime;

    private String uri, ownerUri, ownerGroupUri, lastModifiedUserUri, parentGroupUri;

    @ElementCollection(targetClass=Permission.class, fetch=FetchType.LAZY)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private Set<Permission> ownerPermissions, ownerGroupPermissions, othersPermissions;
    
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
        if (name == null && id != null) {
            name = String.valueOf(id);
        }
    }
    
    @XmlTransient
    public UserEntity getOwner() {
        return Entity.findByURI(UserEntity.class, ownerUri);
    }
    
    public void setOwner(UserEntity owner) {
        if (owner != null) {
            this.ownerUri = owner.getUri();
        }
    }
    
    @XmlTransient
    public GroupEntity getOwnerGroup() {
        return Entity.findByURI(GroupEntity.class, ownerGroupUri);
    }
    
    public void setOwnerGroup(GroupEntity ownerGroup) {
        if (ownerGroup != null) {
            this.ownerGroupUri = ownerGroup.getUri();
        }
    }
    
    public void setParentGroup(GroupEntity group) {
        if (group == null) {
            parentGroupUri = null;
            uri = URI_ROOT + URI_SEPARATOR + name;
        } else {
            parentGroupUri = group.getUri();
            uri = group.getUri() + URI_SEPARATOR + name;
            if (!group.getChildren().contains(this)) {
                group.addChild(this);
            }
        }
    }

    @XmlTransient
    public GroupEntity getParentGroup() {
        return Entity.findByURI(GroupEntity.class, parentGroupUri);
    }
}
