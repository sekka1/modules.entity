package io.algorithms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;
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
    List<String> categories;

    @ElementCollection(targetClass=DataSetEntityBase.class)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    private List<DataSetEntityBase> inputDataSets;

    @ElementCollection(targetClass=DataSetEntityBase.class)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    private List<DataSetEntityBase> outputDataSets;

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
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntityI#getInputDataSets()
     */
    @Override
    public List<DataSetEntityBase> getInputDataSets() {
        return this.inputDataSets;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntityI#setInputDataSets(java.util.List)
     */
    @Override
    public void setInputDataSets(List<DataSetEntityBase> inputDataSets) {
        this.inputDataSets = inputDataSets;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntityI#getOutputDataSets()
     */
    @Override
    public List<DataSetEntityBase> getOutputDataSets() {
        return this.outputDataSets;
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.entity.AlgorithmEntityI#setOutputDataSets(java.util.List)
     */
    @Override
    public void setOutputDataSets(List<DataSetEntityBase> outputDataSets) {
        this.outputDataSets = outputDataSets;
    }

}
