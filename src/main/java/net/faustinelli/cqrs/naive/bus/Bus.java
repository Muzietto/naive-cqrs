/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.bus;

/**
 * Created by Marco Faustinelli (Muzietto) on 27/04/2016.
 */
public interface Bus {
    void register(Object o);
    void unregister(Object o);
    void post(Object o);
}
