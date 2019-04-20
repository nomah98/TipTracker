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
}
