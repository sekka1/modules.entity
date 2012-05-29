package io.algorithms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "user_table")
@XmlRootElement
public class UserEntity extends EntityBase {

    @ElementCollection(targetClass=GroupEntity.class, fetch=FetchType.LAZY)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    @XmlTransient
    private Set<GroupEntity> groups;
    
    @ElementCollection(targetClass=String.class)
    @XmlTransient
    Set<String> authTokens;
}
