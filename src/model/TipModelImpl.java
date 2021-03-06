package model;

import parsing.TipBuilder;
import view.ShiftDisplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TipModelImpl implements ITipModel {
  private HashMap<String, Shift> shiftMap = new HashMap<>();
  private ArrayList<Job> jobList = new ArrayList<>();
  private ArrayList<Person> tippers = new ArrayList<>();


  @Override
  public void addTipper(String name) {
    tippers.add(new Person(name));
  }

  @Override
  public void addJob(String title, double wage) {
    jobList.add(new Job(title, wage));
  }

  @Override
  public void addShift(String date, String shiftName, double shiftLength, String jobTitle, Tip shiftTip,
                       String weather, String timeOfDay) {
    for (int i = 0; i < jobList.size(); i++) {
      if (jobList.get(i).getJobTitle().equalsIgnoreCase(jobTitle)) {
        shiftMap.put(date, (new Shift(shiftName, shiftLength, jobList.get(i),
                shiftTip, weather, timeOfDay)));
      } else {
        throw new IllegalArgumentException();
      }
    }
  }

  @Override
  public void editShift(String date, String shiftName, int shiftLength, String jobTitle, Tip shiftTip,
                        String weather, String timeOfDay) {
    shiftMap.remove(date);
   addShift(date, shiftName, shiftLength, jobTitle, shiftTip, weather, timeOfDay);
  }

  @Override
  public void removeShift(String date) {
    shiftMap.remove(date);
  }

  @Override
  public HashMap<String, Shift> getShiftMap() {
    return shiftMap;
  }

  @Override
  public ArrayList<Job> getJobList() {
    return jobList;
  }

  @Override
  public ArrayList<Person> getTippers() {
    return tippers;
  }


  public void setJobWage(String Title) {

  }

  public ArrayList<ShiftDisplay> setShifts() {
    ArrayList<ShiftDisplay> shiftDisplayList = new ArrayList<>();
    for (Map.Entry<String, Shift> entry: shiftMap.entrySet()) {
      ShiftDisplay sd = new ShiftDisplay(entry.getValue(), entry.getValue().getShiftName(),
              entry.getValue().shiftLength(), entry.getValue().getShiftJob(), entry.getValue().getShiftTip(),
              entry.getValue().getWeather(), entry.getValue().getTimeOfDay());
      shiftDisplayList.add(sd);
    }
    return shiftDisplayList;
  }

  public static final class Builder implements TipBuilder<ITipModel> {
    private TipModelImpl model = new TipModelImpl();

    @Override
    public ITipModel build() {
      return model;
    }

    @Override
    public TipBuilder<ITipModel> declareJobs(String jobName, double wage) {
      model.addJob(jobName, wage);
      return this;
    }

    @Override
    public TipBuilder<ITipModel> declareTippers(String tipperName) {
      model.addTipper(tipperName);
      return this;
    }

    @Override
    public TipBuilder<ITipModel> declareShift(String date, String shiftName, double shiftLength, String shiftJob,
                                              Tip shiftTip, String weather, String timeOfDay) {
      model.addShift(date, shiftName,  shiftLength,  shiftJob, shiftTip,  weather,  timeOfDay );
      return this;
    }
  }
}