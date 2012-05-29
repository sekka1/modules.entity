/*
 * Copyright 2001-2012 ArcSight, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of ArcSight, Inc.
 * Use is subject to license terms.
 *
 * $Author: rajiv$
 * $Date: May 29, 2012$
 */
package io.algorithms.entity;

/**
 * Represents a job.
 */
public interface JobEntity extends Entity {

    public abstract JobStatus getStatus();

    public abstract void setStatus(JobStatus status);

}