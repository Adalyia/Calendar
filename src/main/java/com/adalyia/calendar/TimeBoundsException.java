/**
 * TimeBoundsException.java
 * Purpose: Exception for when time arguments passed to Calendar related classes are out of bounds
 * Author: Emily Cohen
 * Date: 5/1/2023
 */
package com.adalyia.calendar;

public class TimeBoundsException extends IllegalArgumentException
{
    public TimeBoundsException(String message)
    {
        super(message);
    }
}
