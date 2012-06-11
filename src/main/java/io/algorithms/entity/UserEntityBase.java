package io.algorithms.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.context.annotation.Primary;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Repository;

@RooToString
@RooJpaActiveRecord(table = "users")
@XmlRootElement
@Primary
@Repository
public class UserEntityBase implements UserEntity {

    @ElementCollection(targetClass=String.class)
    @XmlTransient
    Set<String> authTokens;
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "user_id_seq")
    private Long id;
    
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datetime_created")
    private Date createTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datetime_modified")
    private Date lastModifiedTime;
    
    @Override
    public Long getId() {
        return this.id;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
        if (name == null && id != null) {
            name = String.valueOf(id);
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Date getCreateTime() {
        return this.createTime;
    }
    
    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Override
    public Date getLastModifiedTime() {
        return this.lastModifiedTime;
    }
    
    @Override
    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
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
