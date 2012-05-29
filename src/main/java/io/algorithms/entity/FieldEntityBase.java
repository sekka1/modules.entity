package io.algorithms.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord
@XmlRootElement
public class FieldEntityBase extends EntityBase implements FieldEntity {

    @Enumerated(EnumType.STRING)
    private DataType dataType;
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.FieldEntityI#getDataType()
     */
    @Override
    public DataType getDataType() {
        return this.dataType;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.FieldEntityI#setDataType(io.algorithms.entity.DataType)
     */
    @Override
    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
}
