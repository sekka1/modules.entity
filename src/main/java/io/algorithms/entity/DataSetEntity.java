/*
 * Copyright 2001-2012 ArcSight, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of ArcSight, Inc.
 * Use is subject to license terms.
 *
 * $Author: rajiv$
 * $Date: May 28, 2012$
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