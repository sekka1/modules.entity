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
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import static io.algorithms.entity.EntityConstants.*;

@RooJpaActiveRecord(identifierField = "id", inheritanceType = "JOINED")
@RooToString
public abstract class EntityBase implements Entity {

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
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getLastModifiedTime() {
        return this.lastModifiedTime;
    }
    
    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
    
    public String getUri() {
        return this.uri;
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }
    
    public String getOwnerUri() {
        return this.ownerUri;
    }
    
    public void setOwnerUri(String ownerUri) {
        this.ownerUri = ownerUri;
    }
    
    public String getOwnerGroupUri() {
        return this.ownerGroupUri;
    }
    
    public void setOwnerGroupUri(String ownerGroupUri) {
        this.ownerGroupUri = ownerGroupUri;
    }
    
    public String getLastModifiedUserUri() {
        return this.lastModifiedUserUri;
    }
    
    public void setLastModifiedUserUri(String lastModifiedUserUri) {
        this.lastModifiedUserUri = lastModifiedUserUri;
    }
    
    public String getParentGroupUri() {
        return this.parentGroupUri;
    }
    
    public void setParentGroupUri(String parentGroupUri) {
        this.parentGroupUri = parentGroupUri;
    }
    
    public Set<Permission> getOwnerPermissions() {
        return this.ownerPermissions;
    }
    
    public void setOwnerPermissions(Set<Permission> ownerPermissions) {
        this.ownerPermissions = ownerPermissions;
    }
    
    public Set<Permission> getOwnerGroupPermissions() {
        return this.ownerGroupPermissions;
    }
    
    public void setOwnerGroupPermissions(Set<Permission> ownerGroupPermissions) {
        this.ownerGroupPermissions = ownerGroupPermissions;
    }
    
    public Set<Permission> getOthersPermissions() {
        return this.othersPermissions;
    }
    
    public void setOthersPermissions(Set<Permission> othersPermissions) {
        this.othersPermissions = othersPermissions;
    }

    @XmlTransient
    public UserEntity getOwner() {
        return EntityBase.findByURI(UserEntity.class, ownerUri);
    }
    
    public void setOwner(UserEntity owner) {
        if (owner != null) {
            this.ownerUri = owner.getUri();
        }
    }
    
    @XmlTransient
    public GroupEntity getOwnerGroup() {
        return EntityBase.findByURI(GroupEntity.class, ownerGroupUri);
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
        return EntityBase.findByURI(GroupEntity.class, parentGroupUri);
    }
    public UserEntity getLastModifiedUser() {
        return EntityBase.findByURI(UserEntity.class, lastModifiedUserUri);
    }
    
    public void setLastModifiedUser(UserEntity lastModifiedUser) {
        if (lastModifiedUser != null) {
            this.lastModifiedUserUri = lastModifiedUser.getUri();
        }
    }
    
}
