/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

/**
 * Represents a job.
 */
public interface JobEntity extends Entity {

    public abstract JobStatus getStatus();

    public abstract void setStatus(JobStatus status);

}