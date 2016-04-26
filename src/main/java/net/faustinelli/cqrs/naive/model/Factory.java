/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, https://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.model;

import net.faustinelli.cqrs.naive.db.DataAccess;
import net.faustinelli.cqrs.naive.db.HibernateConfig;

import java.util.function.Function;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/26/2016.
 */
public class Factory {

    public static Order ORDER(Conference conf, Integer seatsToBook) {
        return new Order(conf, seatsToBook);
    }
}
