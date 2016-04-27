/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.unit;

import net.faustinelli.cqrs.naive.db.DataAccess;
import net.faustinelli.cqrs.naive.model.Factory;
import org.hibernate.classic.Session;

/**
 * Created by Marco Faustinelli (Muzietto) on 27/04/2016.
 */
public class FakeFactory extends Factory {
    @Override
    protected Session getSession() {
        return DataAccess.getSession();
    }

    @Override
    protected <T> T initializeAndUnproxy(T entity) {
        return entity;
    }
}
