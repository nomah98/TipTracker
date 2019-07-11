package view;

import model.IShift;
import model.Job;
import model.Tip;

public class ShiftDisplay {

    private final IShift shift;
    private final String shiftName;
    private final double shiftLength;
    private final Job shiftJob;
    private final Tip shiftTip;
    private final String weather;
    private final String timeOfDay;

    public ShiftDisplay(IShift shift, String shiftName, double shiftLength, Job shiftJob, Tip shiftTip, String weather,
                        String timeOfDay) {
        this.shift = shift;
        this.shiftName = shiftName;
        this.shiftLength = shiftLength;
        this.shiftJob = shiftJob;
        this.shiftTip = shiftTip;
        this.weather = weather;
        this.timeOfDay = timeOfDay;
    }

    public IShift getShift() {
        return shift;
    }

    public String getShiftName() {
        return shiftName;
    }

    public double getShiftLength() {
        return shiftLength;
    }

    public Job getShiftJob() {
        return shiftJob;
    }

    public Tip getShiftTip() {
        return shiftTip;
    }

    public String getWeather() {
        return weather;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }
}
