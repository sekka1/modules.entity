/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

import java.util.List;

/**
 * Algorithm Entity interface.
 */
public interface AlgorithmEntity extends Entity {

    public abstract List<String> getCategories();

    public abstract void setCategories(List<String> categories);

    public abstract List<DataSetEntityBase> getInputDataSets();

    public abstract void setInputDataSets(List<DataSetEntityBase> inputDataSets);

    public abstract List<DataSetEntityBase> getOutputDataSets();

    public abstract void setOutputDataSets(List<DataSetEntityBase> outputDataSets);

}