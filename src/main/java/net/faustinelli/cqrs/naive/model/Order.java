/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, https://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.model;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/26/2016.
 */
public class Order {

    private Conference conference;
    private Integer seatsToBook;

    private Order() {}

    public Order(Conference conf, Integer seatsToBook) {
        this.conference = conf;
        this.seatsToBook = seatsToBook;
    }
}
