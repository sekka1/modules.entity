/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

/**
 * Represents a field
 */
public interface FieldEntity extends Entity {

    DataType getDataType();

    void setDataType(DataType dataType);

}