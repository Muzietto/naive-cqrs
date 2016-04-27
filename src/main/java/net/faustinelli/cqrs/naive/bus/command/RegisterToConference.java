/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, https://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.bus.command;

import net.faustinelli.cqrs.naive.model.Conference;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/26/2016.
 */
public class RegisterToConference implements Command {
    private Conference conference;
    private Integer attendees;

    public RegisterToConference(Conference conference, Integer attendees) {
        this.conference = conference;
        this.attendees = attendees;
    }

    public Integer getAttendees() {
        return attendees;
    }

    public Conference getConference() {
        return conference;
    }
}
