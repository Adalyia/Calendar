/**
 * Event.java
 * Purpose: Event object for Calendar
 * Author: Emily Cohen
 * Date: 5/1/2023
 */
package com.adalyia.calendar;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Event implements EventInterface, Comparable<Event>
{
    // Instance variables
    private String title;
    private String description;
    private String location;
    private LocalDateTime start;
    private LocalDateTime end;
    private final LocalDateTime created;
    private LocalDateTime modified;
    private ArrayList<Tag> tags;
    private ArrayList<String> auditLog;


    /**
     * Constructor for Event
     *
     * @param title The title of the event
     * @param description The description of the event
     * @param location The location of the event
     * @param start The start time of the event
     * @param end The end time of the event
     */
    public Event(String title, String description, String location, LocalDateTime start, LocalDateTime end)
    {
        this.title = title;
        this.description = description;
        this.location = location;
        this.start = start;
        this.end = end;
        this.created = LocalDateTime.now();
        this.modified = this.created;
    }

    /**
     * Returns the title of the event
     *
     * @return The title of the event
     */
    @Override
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Returns the description of the event
     *
     * @return The description of the event
     */
    @Override
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Returns the location of the event
     *
     * @return The location of the event
     */
    @Override
    public String getLocation()
    {
        return this.location;
    }

    /**
     * Returns the start time of the event
     *
     * @return The start time of the event
     */
    @Override
    public LocalDateTime getStart()
    {
        return this.start;
    }

    /**
     * Returns the end time of the event
     *
     * @return The end time of the event
     */
    @Override
    public LocalDateTime getEnd()
    {
        return this.end;
    }

    /**
     * Returns the time the event was created
     *
     * @return The time the event was created
     */
    @Override
    public LocalDateTime getCreated()
    {
        return this.created;
    }

    /**
     * Returns the time the event was last modified
     *
     * @return The time the event was last modified
     */
    @Override
    public LocalDateTime getModified()
    {
        return this.modified;
    }

    /**
     * Returns the duration of the event
     *
     * @return The duration of the event
     */
    @Override
    public Duration getDuration()
    {
        return Duration.between(this.start, this.end);
    }

    /**
     * Returns the reminder for the event
     *
     * @return The reminder for the event
     */
    @Override
    public Duration getReminder()
    {
        return Duration.between(LocalDateTime.now(), this.start);
    }

    /**
     * Returns the tags for the event
     *
     * @return The tags for the event
     */
    @Override
    public ArrayList<Tag> getTags()
    {
        return this.tags;
    }

    /**
     * Returns the audit log for the event, a record of any modifications made
     *
     * @return The audit log for the event
     */
    @Override
    public ArrayList<String> getAuditLog()
    {
        return this.auditLog;
    }

    /**
     * Sets the title of the event
     *
     * @param title The title of the event
     */
    @Override
    public void setTitle(String title)
    {
        this.title = title;
        this.modified = LocalDateTime.now();
        this.auditLog.add(
                String.format(
                        "[%s] Title changed to %s",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        title
                )
        );
    }

    /**
     * Sets the description of the event
     *
     * @param description The description of the event
     */
    @Override
    public void setDescription(String description)
    {
        this.description = description;
        this.modified = LocalDateTime.now();
        this.auditLog.add(
                String.format(
                        "[%s] Description changed to %s",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        description
                )
        );
    }

    /**
     * Sets the location of the event
     *
     * @param location The location of the event
     */
    @Override
    public void setLocation(String location)
    {
        this.location = location;
        this.modified = LocalDateTime.now();
        this.auditLog.add(
                String.format(
                        "[%s] Location changed to %s",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        location
                )
        );
    }

    /**
     * Sets the start time of the event
     *
     * @param start The start time of the event
     */
    @Override
    public void setStart(LocalDateTime start)
    {
        if (start.isAfter(this.end))
        {
            throw new TimeBoundsException("Start time cannot be after end time");
        }

        this.start = start;
        this.modified = LocalDateTime.now();
        this.auditLog.add(
                String.format(
                        "[%s] Start time changed to %s",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        start.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                )
        );

    }

    /**
     * Sets the end time of the event
     *
     * @param end The end time of the event
     */
    @Override
    public void setEnd(LocalDateTime end)
    {
        if (end.isBefore(this.start))
        {
            throw new TimeBoundsException("End time cannot be before start time");
        }

        this.end = end;
        this.modified = LocalDateTime.now();
        this.auditLog.add(
                String.format(
                        "[%s] End time changed to %s",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        end.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                )
        );
    }

    /**
     * Sets the tags for the event
     *
     * @param tags The tags for the event
     */
    @Override
    public void setTags(ArrayList<Tag> tags)
    {
        this.tags = tags;
        this.modified = LocalDateTime.now();
        this.auditLog.add(
                String.format(
                        "[%s] Tags changed to %s",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        tags.toString()
                )
        );
    }

    /**
     * Returns a string representation of the event
     *
     * @return A string representation of the event
     */
    @Override
    public String toString()
    {
        return String.format("Title: %s\nDescription: %s\nLocation: %s\nStart: %s\nEnd: %s\nCreated: %s\nModified: %s\nDuration: %s\nReminder: %s\n",
            this.title, this.description, this.location, this.start, this.end, this.created, this.modified, this.getDuration(), this.getReminder());
    }

    /**
     * Whether the event is equal to another object
     *
     * @param o The object to be compared
     * @return Whether the event is equal to another object
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == this)
        {
            return true;
        }

        if (!(o instanceof Event e))
        {
            return false;
        }

        return this.title.equals(e.title) && this.description.equals(e.description) && this.location.equals(e.location) && this.start.equals(e.start) && this.end.equals(e.end) && this.created.equals(e.created) && this.modified.equals(e.modified);
    }

    /**
     * Compares this event with the specified event for order. Returns a negative integer, zero, or a positive integer as this event is less than, equal to, or greater than the specified event.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Event o)
    {
        return this.start.isBefore(o.getStart()) ? -1 : (this.start.isAfter(o.getStart()) ? 1 : 0);
    }
}
