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

    List<String> getCategories();

    void setCategories(List<String> categories);
}