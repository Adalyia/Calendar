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
        System.out.println("6. Exit");

        String input = Integer.toString(promptInt("Enter the number of the option you would like to select: "));

        switch (Integer.parseInt(input))
        {
            case 1 ->
            {
                // Add a task
                calendar.addEvent(taskPrompt());
            }
            case 2 ->
            {
                // Add an event
                calendar.addEvent(eventPrompt());
            }
            case 3 ->
            {
                // Add a tag
                ArrayList<TagInterface> tags = calendar.getTags();
                tags.add(tagPrompt());
                calendar.setTags(tags);
            }
            case 4 ->
            {
                // View tasks/events
                System.out.println(calendar.getEvents());
            }
            case 5 -> System.out.println(calendar.getTags());
            case 6 ->
            {
                // Exit
                System.out.println("Goodbye!");
                System.exit(0);
            }

            default ->
            {
                System.out.println("Invalid input. Please try again.");
                optionsMenu(calendar);
            }
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
        System.out.print("Enter the due date for this task below ");
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
        System.out.print("Enter the start time for the event below ");
        LocalDateTime start = dateTimePrompt();
        System.out.print("Enter the end time for the event below ");
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
        System.out.println();
        int year = promptInt("\tEnter the year (whole number): ");
        int month = promptInt("\tEnter the month (whole number): ");
        int day = promptInt("\tEnter the day (whole number): ");
        int hour = promptInt("\tEnter the hour (whole number): ");
        int minute = promptInt("\tEnter the minute (whole number): ");
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public static int promptInt(String prompt)
    {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input must be a number. Please try again.");
            return promptInt(prompt);
        }
    }
}