/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.unit;

import net.faustinelli.cqrs.naive.bus.Bus;

/**
 * Created by Marco Faustinelli (Muzietto) on 27/04/2016.
 */
public class FakeCommandBus implements Bus {
    @Override
    public void register(Object o) {

    }

    @Override
    public void unregister(Object o) {

    }

    @Override
    public void post(Object o) {

    }
}
