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

/**
 * Represents a field
 */
public interface FieldEntity {

    public abstract DataType getDataType();

    public abstract void setDataType(DataType dataType);

}