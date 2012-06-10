/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

import java.util.List;

/**
 * Interface for dataset.
 */
public interface DataSetEntity extends Entity {

    long getSize();

    void setSize(long size);

    DataFormat getFormat();

    void setFormat(DataFormat format);

    List<FieldEntityBase> getFields();

    void setFields(List<FieldEntityBase> fields);

}