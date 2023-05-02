/**
 * CalendarInterface.java
 * Purpose: Interface for Calendar objects
 * Author: Emily Cohen
 * Date: 5/1/2023
 */
package com.adalyia.calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface CalendarInterface
{
    // Getters for Calendar properties
    String getName();
    String getDescription();
    LocalDateTime getCreated();
    LocalDateTime getModified();
    ArrayList<EventInterface> getEvents();
    ArrayList<TagInterface> getTags();


    // Setters for Calendar properties
    void setName(String name);
    void setDescription(String description);
    void setEvents(ArrayList<EventInterface> events);
    void addEvent(EventInterface event);
    void removeEvent(EventInterface event);
    void setTags(ArrayList<TagInterface> tags);
}
