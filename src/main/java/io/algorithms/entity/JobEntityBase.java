package io.algorithms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord(table="jobs")
@XmlRootElement
public class JobEntityBase implements JobEntity {

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_seq")
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
     * @see io.algorithms.entity.JobEntityI#getStatus()
     */
    @Override
    public JobStatus getStatus() {
        return this.status;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.JobEntityI#setStatus(io.algorithms.entity.JobStatus)
     */
    @Override
    public void setStatus(JobStatus status) {
        this.status = status;
    }
}
