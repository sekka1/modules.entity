/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: Feb 22, 2012$
*/
package io.algorithms.entity;

privileged aspect UserEntity_Custom_ActiveRecord {
    /**
     * Find user by auth token.
     * @param type
     * @param uri
     * @return
     */
    public static UserEntity UserEntity.findUserEntityByAuthToken(String authToken) {
        if (authToken == null) {
            return null;
        }
        
        try {
            return (UserEntity) entityManager().createQuery("select u from User u where :authToken in elements(u.authTokens)")
                    .setParameter("authToken", authToken).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
