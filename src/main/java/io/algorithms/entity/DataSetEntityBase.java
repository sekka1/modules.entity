package io.algorithms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord
@XmlRootElement
@Table(name="datasources")
public class DataSetEntityBase implements DataSetEntity {
    
    private long size;

    @Column(name="location")
    private String dataSource; 

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_seq")
    private Long id;

    @Column(name="friendly_name")
    private String name;

    @Column(name="friendly_description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datetime_created")
    private Date createTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datetime_modified")
    private Date lastModifiedTime;

    @ManyToOne
    @JoinColumn(name="customer_id_seq")
    private UserEntityBase owner;
    
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
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public UserEntity getOwner() {
        return owner;
    }
    
    @Override
    public void setOwner(UserEntityBase owner) {
        this.owner = owner;
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntityI#getSize()
     */
    @Override
    public long getSize() {
        return this.size;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntityI#setSize(long)
     */
    @Override
    public void setSize(long size) {
        this.size = size;
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntity#getDataSource()
     */
    @Override
    public String getDataSource() {
        return dataSource;
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntity#setDataSource(java.lang.String)
     */
    @Override
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    
}
