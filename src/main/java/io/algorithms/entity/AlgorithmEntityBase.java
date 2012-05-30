package io.algorithms.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.OrderColumn;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooJpaActiveRecord
@XmlRootElement
public class AlgorithmEntityBase extends EntityBase implements AlgorithmEntity {
    @ElementCollection(targetClass=String.class)
    @OrderColumn
    private List<String> categories;
//
//    private Algorithm algorithm;
    
//    @ElementCollection(targetClass=DataSetEntityBase.class)
//    @OneToMany(cascade=CascadeType.ALL)
//    @OrderColumn
//    private List<DataSetEntityBase> inputDataSets;
//
//    @ElementCollection(targetClass=DataSetEntityBase.class)
//    @OneToMany(cascade=CascadeType.ALL)
//    @OrderColumn
//    private List<DataSetEntityBase> outputDataSets;

    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntityI#getCategories()
     */
    @Override
    public List<String> getCategories() {
        return this.categories;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntityI#setCategories(java.util.List)
     */
    @Override
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
