package model;

import java.util.Calendar;
import java.util.Date;

public interface ITipModel {

    /**
     * Add an employee that tips you to the list
     * @param name
     */
    void addTipper(Person name);

    /**
     * Add the place that the designated tipper is working
     * @param place
     */
    void addLocation(Location place);

    /**
     * Add a job title at a designated location
     * @param title
     * @param place
     */
    void addJob(Job title, Location place);

    /**
     * Builds the Calendar to use
     * @return Calendar
     */
    Calendar makeCalendar();

    /**
     * Adding a tip earned at a specific place from a specific person, of a specific amount
     * @param place the establishment where tipped
     * @param title the job working while tipped
     * @param name
     */
    void addTip(Location place, Job title, Person name, int amount, Shift time, Date date);
}
