package io.algorithms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord(table="algorithms")
@XmlRootElement
public class AlgorithmEntityBase implements AlgorithmEntity {
    @Column(name="class")
    private String category;
    
    @Column(name="implementation_class")
    private String implementation;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_seq")
    private Long id;
    
    private String name;

    private String description;

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

    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntityI#getCategories()
     */
    @Override
    public String getCategory() {
        return this.category;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntityI#setCategories(java.util.List)
     */
    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntity#getAlgorithm()
     */
    @Override
    public Algorithm getAlgorithm() throws AlgorithmNotFoundException {
        return AlgorithmRegister.getAlgorithm(implementation);
    }

    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntity#setAlgorithm(io.algorithms.entity.Algorithm)
     */
    @Override
    public void setAlgorithm(Algorithm algorithm) throws AlgorithmDuplicateException, AlgorithmException {
        AlgorithmRegister.registerAlgorithm(algorithm.getImplementationClass(), algorithm);
        this.implementation = algorithm.getImplementationClass();
    }
}
