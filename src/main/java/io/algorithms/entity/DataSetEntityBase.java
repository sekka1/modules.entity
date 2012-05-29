package io.algorithms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord
@XmlRootElement
public class DataSetEntityBase extends EntityBase implements DataSetEntity {
    
    private long size;

    @Enumerated(EnumType.STRING)
    private DataFormat format;

    @ElementCollection(targetClass=FieldEntityBase.class)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    private List<FieldEntityBase> fields;

    @XmlTransient
    @Transient
    private DataStore dataStore;
    
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
     * @see io.algorithms.entity.DataSetEntityI#getFormat()
     */
    @Override
    public DataFormat getFormat() {
        return this.format;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntityI#setFormat(io.algorithms.entity.DataFormat)
     */
    @Override
    public void setFormat(DataFormat format) {
        this.format = format;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntityI#getFields()
     */
    @Override
    public List<FieldEntityBase> getFields() {
        return this.fields;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntityI#setFields(java.util.List)
     */
    @Override
    public void setFields(List<FieldEntityBase> fields) {
        this.fields = fields;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntityI#getDataStore()
     */
    @Override
    public DataStore getDataStore() {
        return this.dataStore;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.DataSetEntityI#setDataStore(io.algorithms.entity.DataStore)
     */
    @Override
    public void setDataStore(DataStore fileStore) {
        this.dataStore = fileStore;
    }
}
