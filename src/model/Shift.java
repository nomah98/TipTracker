package model;

public class Shift implements IShift {
    private String shiftName;
    private double shiftLength;
    private Job shiftJob;
    private Tip shiftTip;
    private String weather;
    private String timeOfDay;

    public Shift(String shiftName, double shiftLength, Job shiftJob, Tip shiftTip, String weather,
                 String timeOfDay) {
        this.shiftName = shiftName;
        this.shiftLength = shiftLength;
        this.shiftJob = shiftJob;
        this.shiftTip = shiftTip;
        this.weather = weather;
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String getShiftName() {
        return shiftName;
    }

    @Override
    public double shiftLength() {
        return shiftLength;
    }

    @Override
    public Tip getShiftTip() {
        return shiftTip;
    }

    @Override
    public Job getShiftJob() {
        return shiftJob;
    }

    @Override
    public String getWeather() {
        return weather;
    }

    @Override
    public String getTimeOfDay() {
        return timeOfDay;
    }
}
