/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.model;

import javax.persistence.*;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/25/2016.
 */
@Entity
@Table(name = "CONFERENCES")
public class Conference {
    @Id
    @GeneratedValue
    @Column(name = "CONFERENCE_ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "NUM_SEATS")
    private Integer numSeats;

    public Conference() {}

    public Conference(String title, Integer numSeats) {
        this.title = title;
        this.numSeats = numSeats;
    }

    public Conference(String title) {
        this(title, 100);
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumSeats() { return numSeats; }

    public void setNumSeats(Integer numSeats) { this.numSeats = numSeats; }

}
