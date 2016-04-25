/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.db;

import javax.persistence.*;
/**
 * Created by Marco Faustinelli (Muzietto) on 4/25/2016.
 */
@Entity
@Table(name="MESSAGES")
public class Message {
    @Id
    @GeneratedValue
    @Column(name="MESSAGE_ID")
    private Long id;

    @Column(name="TEXT", nullable=false)
    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="NEXT_MESSAGE_ID", nullable=true)
    private Message nextMessage;

    public Message() {}

    public Message(String text) {
        this.text = text;
    }
    public Long getId() {
        return id;
    }
    private void setId(Long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Message getNextMessage() {
        return nextMessage;
    }
    public void setNextMessage(Message nextMessage) {
        this.nextMessage = nextMessage;
    }
}
