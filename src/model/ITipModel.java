package model;

import view.ShiftDisplay;

import java.util.ArrayList;
import java.util.HashMap;

public interface ITipModel {

    /**
     * Add an employee that tips you to the list
     * @param name the name of the added employee
     */
    void addTipper(String name);

    /**
     * Add a job title to the list of Jobs
     * @param title the title of the Job worked
     */
    void addJob(String title, double wage);

    /**
     *
     * @param date when the shift took place
     * @param shiftName what kind of shift it was
     * @param shiftLength the length of the shift in hours
     * @param jobTitle the title of the job worked during the shift
     * @param shiftTip the Tip from the shift
     * @param weather the weather during the shift
     * @param timeOfDay what part of the day the shift occured during
     */
     void addShift(String date, String shiftName, double shiftLength, String jobTitle,
                         Tip shiftTip, String weather, String timeOfDay);

    /**
     *
     * @param date when the shift took place
     * @param shiftName what kind of shift it was
     * @param shiftLength the length of the shift in hours
     * @param jobTitle the title of the job worked during the shift
     * @param shiftTip the Tip from the shift
     * @param weather the weather during the shift
     * @param timeOfDay what part of the day the shift occured during
     */
     void editShift(String date, String shiftName, int shiftLength, String jobTitle,
                    Tip shiftTip, String weather, String timeOfDay);

    /**
     *
     * @param date the date of the shift to find for removal
     */
    void removeShift(String date);

    /**
     *
     * @return the HashMap<String, Shift> that represnets shifts
     */
    HashMap<String, Shift> getShiftMap();

    /**
     *
     * @return the ArrayList<Job> that represents the list of Jobs
     */
    ArrayList<Job> getJobList();

    /**
     *
     * @return he ArrayList<Job> that represents the list of Persons that tipped
     */
    ArrayList<Person> getTippers();

    ArrayList<ShiftDisplay> setShifts();

}
