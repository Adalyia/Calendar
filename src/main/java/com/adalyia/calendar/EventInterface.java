/**
 * EventInterface.java
 * Purpose: Interface for Calendar Tasks & Events
 * Author: Emily Cohen
 * Date: 5/1/2023
 */
package com.adalyia.calendar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface EventInterface
{
    // Getters for Calendar Task/Event properties
    String getTitle();
    String getDescription();
    String getLocation();
    LocalDateTime getStart();
    LocalDateTime getEnd();
    LocalDateTime getCreated();
    LocalDateTime getModified();
    Duration getDuration();
    Duration getReminder();
    ArrayList<Tag> getTags();
    ArrayList<String> getAuditLog();

    // Setters for Calendar Task/Event properties
    void setTitle(String title);
    void setDescription(String description);
    void setLocation(String location);
    void setStart(LocalDateTime start);
    void setEnd(LocalDateTime end);
    void setTags(ArrayList<Tag> tags);
}
