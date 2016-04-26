/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, https://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/26/2016.
 */
@Entity
@Table(name = "SEAT_AVAILABILITIES")
public class SeatAvailability implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="CONFERENCE_ID", nullable=false)
    private Conference conference;

    @Column(name = "AVAILABLE_SEATS")
    private Integer availableSeats;

    private SeatAvailability() {}

    public SeatAvailability(Conference conference) {
        this.conference = conference;
        this.availableSeats = conference.getNumSeats();
    }

    public Integer availableSeats() {
        return new Integer(availableSeats);
    }

    public boolean bookSeats(Integer seatsToBook) {
        if (seatsToBook > this.availableSeats) {
            return false;
        } else {
            // TODO - think about concurrent access
            this.availableSeats = this.availableSeats - seatsToBook;
            return true;
        }
    }
}
