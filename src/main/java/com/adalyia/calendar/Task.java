/**
 * Task.java
 * Purpose: Task object for Calendar, Tasks are Events with no duration
 * Author: Emily Cohen
 * Date: 5/1/2023
 * TODO:
 * - Address the lack of change tracking and last modified date
 */
package com.adalyia.calendar;

import java.time.LocalDateTime;

public class Task extends Event implements TaskInterface
{
    private boolean completed;


    /**
     * Constructor for Task
     *
     * @param title       The title of the task
     * @param description The description of the task
     * @param location    The location of the task
     * @param time        The time of the task
     */
    public Task(String title, String description, String location, LocalDateTime time)
    {
        super(title, description, location, time, time);
        this.completed = false;
    }

    /**
     * Returns the completion status of the task
     *
     * @return The completion status of the task
     */
    public boolean isCompleted()
    {
        return this.completed;
    }

    /**
     * Sets the completion status of the task
     *
     * @param completed The new completion status of the task
     */
    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }
}
