/**
 * TagInterface.java
 * Purpose: Interface for Calendar Tags
 * Author: Emily Cohen
 * Date: 5/1/2023
 */
package com.adalyia.calendar;

import java.time.LocalDateTime;
import java.util.UUID;

public interface TagInterface
{
    // Getters for Calendar Tag properties
    UUID getId();
    String getName();
    String getDescription();
    LocalDateTime getCreated();
    LocalDateTime getModified();

    // Setters for Calendar Tag properties
    void setName(String name);
    void setDescription(String description);
}
