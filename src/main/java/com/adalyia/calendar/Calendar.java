/**
 * Calendar.java
 * Purpose: Class for Calendar
 * Author: Emily Cohen
 * Date: 5/1/2023
 */
package com.adalyia.calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Calendar implements CalendarInterface
{
    // Instance variables
    private String name;
    private String description;
    private final LocalDateTime created;
    private LocalDateTime modified;
    private ArrayList<EventInterface> events;
    private ArrayList<TagInterface> tags;

    /**
     * Constructs a new Calendar object with the given name and description.
     * The created and modified dates are set to the current date and time.
     *
     * @param name the name of the calendar
     * @param description the description of the calendar
     */
    public Calendar(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
        this.events = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    /**
     * Returns the name of the calendar.
     *
     * @return the name of the calendar
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the description of the calendar.
     *
     * @return the description of the calendar
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the date and time the calendar was created.
     *
     * @return the date and time the calendar was created
     */
    @Override
    public LocalDateTime getCreated() {
        return this.created;
    }

    /**
     * Returns the date and time the calendar was last modified.
     *
     * @return the date and time the calendar was last modified
     */
    @Override
    public LocalDateTime getModified() {
        return this.modified;
    }

    /**
     * Returns the events in the calendar.
     *
     * @return the events in the calendar
     */
    @Override
    public ArrayList<EventInterface> getEvents() {
        return events;
    }

    /**
     * Returns the tags in the calendar.
     *
     * @return the tags in the calendar
     */
    @Override
    public ArrayList<TagInterface> getTags() {
        return tags;
    }

    /**
     * Sets the name of the calendar.
     *
     * @param name the new name of the calendar
     */
    @Override
    public void setName(String name) {
        this.name = name;
        this.modified = LocalDateTime.now();
    }

    /**
     * Sets the description of the calendar.
     *
     * @param description the new description of the calendar
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
        this.modified = LocalDateTime.now();
    }

    /**
     * Sets the events in the calendar.
     *
     * @param events the new events in the calendar
     */
    @Override
    public void setEvents(ArrayList<EventInterface> events) {
        this.events = events;
        this.modified = LocalDateTime.now();
    }

    /**
     * Adds an event to the calendar.
     *
     * @param event the event to add to the calendar
     */
    @Override
    public void addEvent(EventInterface event) {
        this.events.add(event);
        this.modified = LocalDateTime.now();
    }

    /**
     * Removes an event from the calendar.
     *
     * @param event the event to remove from the calendar
     */
    @Override
    public void removeEvent(EventInterface event) {
        this.events.remove(event);
        this.modified = LocalDateTime.now();
    }

    /**
     * Sets the tags in the calendar.
     *
     * @param tags the new tags in the calendar
     */
    @Override
    public void setTags(ArrayList<TagInterface> tags) {
        this.tags = tags;
        this.modified = LocalDateTime.now();
    }

    /**
     * Returns whether the given object is equal to this calendar.
     * @param o the object to compare to this calendar
     * @return whether the given object is equal to this calendar
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return Objects.equals(name, calendar.name) &&
                Objects.equals(description, calendar.description) &&
                Objects.equals(created, calendar.created) &&
                Objects.equals(modified, calendar.modified) &&
                Objects.equals(events, calendar.events) &&
                Objects.equals(tags, calendar.tags);
    }

    /**
     * Returns a string representation of this calendar.
     * @return a string representation of this calendar
     */
    @Override
    public String toString() {
        return String.format("Name: %s\nDescription: %s\nCreated: %s\nModified: %s\nEvents: %s\nTags: %s",
                this.name, this.description, this.created, this.modified, this.events, this.tags);
    }
}
