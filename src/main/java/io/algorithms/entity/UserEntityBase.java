package io.algorithms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord(table = "user_table")
@XmlRootElement
public class UserEntityBase extends EntityBase implements UserEntity {

    @ElementCollection(targetClass=GroupEntityBase.class, fetch=FetchType.LAZY)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    @XmlTransient
    private Set<GroupEntityBase> groups;
    
    @ElementCollection(targetClass=String.class)
    @XmlTransient
    Set<String> authTokens;
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.UserEntityI#getGroups()
     */
    @Override
    public Set<GroupEntityBase> getGroups() {
        return this.groups;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.UserEntityI#setGroups(java.util.Set)
     */
    @Override
    public void setGroups(Set<GroupEntityBase> groups) {
        this.groups = groups;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.UserEntityI#getAuthTokens()
     */
    @Override
    public Set<String> getAuthTokens() {
        return this.authTokens;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.UserEntityI#setAuthTokens(java.util.Set)
     */
    @Override
    public void setAuthTokens(Set<String> authTokens) {
        this.authTokens = authTokens;
    }
}
