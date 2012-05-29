package io.algorithms.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord
@XmlRootElement
public class JobEntityBase extends EntityBase implements JobEntity {

    @Enumerated(EnumType.STRING)
    private JobStatus status;

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
