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

    public abstract long getSize();

    public abstract void setSize(long size);

    public abstract DataFormat getFormat();

    public abstract void setFormat(DataFormat format);

    public abstract List<FieldEntityBase> getFields();

    public abstract void setFields(List<FieldEntityBase> fields);

    public abstract DataStore getDataStore();

    public abstract void setDataStore(DataStore fileStore);

}