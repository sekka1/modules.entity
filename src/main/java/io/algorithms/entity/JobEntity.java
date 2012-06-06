/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
*/
package io.algorithms.entity;

/**
 * Represents a job.
 */
public interface JobEntity extends Entity {

    JobStatus getStatus();

    void setStatus(JobStatus status);

}