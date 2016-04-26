/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.db;

import org.hibernate.classic.Session;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/26/2016.
 */
public interface DataAccess {
    public static Session getSession() {
        return null;
    }
}
