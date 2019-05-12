package model;

public interface IShift {

    /**
     * Return the name of this Shift.
     *
     * @return Shift name
     */
    String getShiftName();

    /**
     * Return the length of this shift in hours
     * @return length of shift
     */
    double shiftLength();

    /**
     *  Returns the Tip from the given shift
     * @return Tip from shift
     */
    Tip getShiftTip();

    /**
     * Returns the Job that was worked on the given shift
     * @return Job from shift
     */
    Job getShiftJob();

    /**
     * Returns the weather for the given shift
     * @return String weather
     */
    String getWeather();

    /**
     * Returns the timeOfDay for the given shift
     * @return String timeOfDay
     */
    String getTimeOfDay();

}
