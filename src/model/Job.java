package model;

public class Job implements IJob {

    private String jobTitle;
    private double wage;

    public Job(String jobTitle, double wage) {
        this.jobTitle = jobTitle;
        this.wage = wage;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double getWage() {
        return wage;
    }
}
