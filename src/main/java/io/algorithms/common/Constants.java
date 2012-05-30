/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: Apr 16, 2012$
*/
package io.algorithms.common;

import io.algorithms.entity.Permission;

import java.util.EnumSet;
import java.util.Set;

/**
 * Constants common to all classes.
 */
public final class Constants {
    public static final String URI_SEPARATOR = "/", URI_ROOT = "root",
            URI_USERS = URI_ROOT + URI_SEPARATOR + "users", URI_USERS_ADMINS = URI_USERS + URI_SEPARATOR + "admins",
            URI_USERS_ADMINS_ADMIN = URI_USERS_ADMINS + URI_SEPARATOR + "admin", URI_HOME = URI_ROOT + URI_SEPARATOR + "home";
    
    public static final Set<Permission> PERMISSIONS_DEFAULT_OWNER = EnumSet.of(Permission.READ, Permission.WRITE),
            PERMISSIONS_DEFAULT_OWNER_GROUP = EnumSet.of(Permission.READ, Permission.WRITE), PERMISSIONS_DEFAULT_OTHER = EnumSet.noneOf(Permission.class);
}
