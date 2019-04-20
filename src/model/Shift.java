package model;

public class Shift implements IShift {
    private String shiftName;
    private double shiftLength;
    private Job title;

    public Shift(String shiftName, double shiftLength, Job title) {
        this.shiftName = shiftName;
        this.shiftLength = shiftLength;
        this.title = title;
    }

    @Override
    public String getShiftName() {
        return shiftName;
    }

    @Override
    public double shiftLength() {
        return shiftLength;
    }

    public Job getTitle() {
        return title;
    }
}
