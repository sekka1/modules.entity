package io.algorithms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@XmlRootElement
public class AlgorithmEntity extends Entity {
    @ElementCollection(targetClass=String.class)
    @OrderColumn
    List<String> categories;

    @ElementCollection(targetClass=DataSetEntity.class)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    private List<DataSetEntity> inputDataSets;

    @ElementCollection(targetClass=DataSetEntity.class)
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    private List<DataSetEntity> outputDataSets;

}
