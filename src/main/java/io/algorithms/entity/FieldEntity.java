/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

/**
 * Represents a field
 */
public interface FieldEntity extends Entity {

    public abstract DataType getDataType();

    public abstract void setDataType(DataType dataType);

}