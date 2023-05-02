/**
 * Tag.java
 * Purpose: Tag object for Calendar
 * Author: Emily Cohen
 * Date: 5/1/2023
 */
package com.adalyia.calendar;

import java.time.LocalDateTime;

public class Tag implements TagInterface
{
    // Instance variables
    private String name;
    private String description;
    private final LocalDateTime created;
    private LocalDateTime modified;

    /**
     * Constructs a new Tag object with the given name and description.
     * The created and modified dates are set to the current date and time.
     *
     * @param name the name of the tag
     * @param description the description of the tag
     */
    public Tag(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.created = LocalDateTime.now();
        this.modified = this.created;
    }

    /**
     * Gets the name of the tag.
     *
     * @return the name of the tag
     */
    @Override
    public String getName()
    {
        return this.name;
    }

    /**
     * Sets the name of the tag.
     *
     * @param name the new name of the tag
     */
    @Override
    public void setName(String name)
    {
        this.name = name;
        this.modified = LocalDateTime.now();
    }

    /**
     * Gets the description of the tag.
     *
     * @return the description of the tag
     */
    @Override
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Sets the description of the tag.
     *
     * @param description the new description of the tag
     */
    @Override
    public void setDescription(String description)
    {
        this.description = description;
        this.modified = LocalDateTime.now();
    }

    /**
     * Gets the date and time when the tag was created.
     *
     * @return the date and time when the tag was created
     */
    @Override
    public LocalDateTime getCreated()
    {
        return this.created;
    }

    /**
     * Gets the date and time when the tag was last modified.
     *
     * @return the date and time when the tag was last modified
     */
    @Override
    public LocalDateTime getModified()
    {
        return this.modified;
    }

    /**
     * Returns a string representation of the Tag object.
     *
     * @return a string representation of the Tag object
     */
    @Override
    public String toString()
    {
        return String.format("Tag: %s\nDescription: %s\nCreated: %s\nModified: %s\n",
                this.name, this.description, this.created, this.modified);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return true if this object is the same as the o argument; false otherwise
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (!this.name.equals(tag.name)) return false;
        return this.description.equals(tag.description);
    }
}
