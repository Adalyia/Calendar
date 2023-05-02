/**
 * Client.java
 * Purpose: Client for Calendar
 * Author: Emily Cohen
 * Date: 5/1/2023
 * TODO:
 * - Add missing methods to Calendar object
 * - Add missing methods to Tag object
 * - Add missing methods to Task object
 * - Cleanup toString methods for Calendar, Tag, and Task objects
 * - (Optional) Add save/load functionality to Calendar object
 */
package com.adalyia.calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Client
{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        Calendar calendar = createCalendarMenu();
        String input = "";
        do {
            optionsMenu(calendar);
            System.out.print("Would you like to continue? (y/n): ");
            input = scanner.nextLine();
        } while (input.equalsIgnoreCase("y"));
    }

    public static Calendar createCalendarMenu()
    {
        System.out.print("Enter the name of your calendar: ");
        String name = scanner.nextLine();
        System.out.print("Enter a description for your calendar: ");
        String description = scanner.nextLine();
        return new Calendar(name, description);
    }

    public static void optionsMenu(Calendar calendar)
    {
        System.out.println("Options:");
        System.out.println("1. Add a task");
        System.out.println("2. Add an event");
        System.out.println("3. Add a tag");
        System.out.println("4. View tasks/events");
        System.out.println("5. View tags");

        System.out.print("Enter the number of the option you would like to select: ");
        String input = scanner.nextLine();

        switch (Integer.parseInt(input)) {
            case 1:
                // Add a task
                calendar.addEvent(taskPrompt());
                break;
            case 2:
                // Add an event
                calendar.addEvent(eventPrompt());
                break;
            case 3:
                // Add a tag
                ArrayList<TagInterface> tags = calendar.getTags();
                tags.add(tagPrompt());
                calendar.setTags(tags);
                break;
            case 4:
                // View tasks/events
                System.out.println(calendar.getEvents());
                break;
            case 5:
                // View tags
                System.out.println(calendar.getTags());
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                optionsMenu(calendar);
        }
    }

    public static Task taskPrompt()
    {
        // Add a task
        System.out.print("Enter the name of the task: ");
        String name = scanner.nextLine();
        System.out.print("Enter a description for the task: ");
        String description = scanner.nextLine();
        System.out.print("Enter the location for this task: ");
        String location = scanner.nextLine();
        System.out.print("Enter the due date for this task: ");
        LocalDateTime dueDate = dateTimePrompt();
        return new Task(name, description, location, dueDate);
    }

    public static Event eventPrompt()
    {
        // Add an event
        System.out.print("Enter the name of the event: ");
        String name = scanner.nextLine();
        System.out.print("Enter a description for the event: ");
        String description = scanner.nextLine();
        System.out.print("Enter the location for this event: ");
        String location = scanner.nextLine();
        System.out.print("Enter the start time for the event: ");
        LocalDateTime start = dateTimePrompt();
        System.out.print("Enter the end time for the event: ");
        LocalDateTime end = dateTimePrompt();
        return new Event(name, description, location, start, end);
    }

    public static Tag tagPrompt()
    {
        // Add a tag
        System.out.print("Enter the name of the tag: ");
        String name = scanner.nextLine();
        System.out.print("Enter a description for the tag: ");
        String description = scanner.nextLine();
        return new Tag(name, description);
    }

    public static LocalDateTime dateTimePrompt()
    {
        System.out.print("Enter the year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the month: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the day: ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the hour: ");
        int hour = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the minute: ");
        int minute = Integer.parseInt(scanner.nextLine());
        return LocalDateTime.of(year, month, day, hour, minute);
    }
}