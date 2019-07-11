package model;

import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class TipModelImplTest {

  TipModelImpl testImpl = new TipModelImpl();

  @Test
  public void addJobTest() {

    testImpl.addJob("Barback", 6);
    testImpl.addJob("Foodrunner", 8);
    assertEquals(testImpl.getJobList().get(0).getJobTitle(), "Barback");
    assertEquals(testImpl.getJobList().get(1).getJobTitle(), "Foodrunner");
    assertEquals(testImpl.getJobList().get(0).getWage(), 6.0, 0);
    assertEquals(testImpl.getJobList().get(1).getWage(), 8.0, 0);
  }

  @Test
  public void addTippersTest() {

    testImpl.addTipper("KO");
    testImpl.addTipper("Olivia");
    testImpl.addTipper("Sean");
    assertEquals(testImpl.getTippers().get(0).getName(), "KO");
    assertEquals(testImpl.getTippers().get(1).getName(), "Olivia");
    assertEquals(testImpl.getTippers().get(2).getName(), "Sean");
  }

  @Test
  public void addShiftTest() {
    testImpl.addTipper("KO");
    testImpl.addTipper("Olivia");
    testImpl.addTipper("Sean");
    Tip testTipList = new Tip(testImpl.getTippers());

    ArrayList<Person> testListNames = new ArrayList<>();
    testListNames.add(new Person("KO"));
    testListNames.add(new Person("Olivia"));
    testListNames.add(new Person("Sean"));

    testImpl.addJob("Barback", 6);

    testImpl.addShift("5/12", "Single", 9, "Barback", testTipList,
            "rainy", "Morning");


    assertTrue(testImpl.getShiftMap().containsKey("5/12"));
    assertEquals(testImpl.getShiftMap().get("5/12").shiftLength(), 9.0, 0);
    assertEquals(testImpl.getShiftMap().get("5/12").getShiftName(), "Single");
    assertEquals(testImpl.getShiftMap().get("5/12").getTimeOfDay(), "Morning");
    assertEquals(testImpl.getShiftMap().get("5/12").getWeather(), "rainy");
    assertEquals(testImpl.getShiftMap().get("5/12").getShiftJob().getJobTitle(), "Barback");
    assertEquals(testImpl.getShiftMap().get("5/12").getShiftTip().getTippers().get(0).getName(),
            testListNames.get(0).getName());
    assertEquals(testImpl.getShiftMap().get("5/12").getShiftTip().getTippers().get(2).getName(),
            testListNames.get(2).getName());
    try {
      testImpl.addShift("5/13", "Single", 9, "busboy", testTipList,
              "rainy", "night");
    } catch (IllegalArgumentException a) {

    }
  }

  @Test
  public void editShiftTest() {
    testImpl.addTipper("KO");
    testImpl.addTipper("Olivia");
    testImpl.addTipper("Sean");
    Tip testTipList = new Tip(testImpl.getTippers());


    ArrayList<Person> testListNames = new ArrayList<>();
    testListNames.add(new Person("KO"));
    testListNames.add(new Person("Olivia"));
    testListNames.add(new Person("Sean"));

    testImpl.addJob("Barback", 6);

    testImpl.addShift("5/12", "Single", 9, "Barback", testTipList,
            "rainy", "Morning");
    testImpl.addShift("5/13", "Single", 11, "Barback", testTipList,
            "sunny", "Morning");

    testImpl.editShift("5/13", "Double", 14, "Barback", testTipList,
            "sunny", "Day");

    assertEquals(testImpl.getShiftMap().get("5/13").shiftLength(), 14.0, 0);
    assertEquals(testImpl.getShiftMap().get("5/13").getShiftName(), "Double");
    assertEquals(testImpl.getShiftMap().get("5/13").getTimeOfDay(), "Day");
    assertEquals(testImpl.getShiftMap().get("5/13").getWeather(), "sunny");
    assertEquals(testImpl.getShiftMap().get("5/13").getShiftJob().getJobTitle(), "Barback");
    assertEquals(testImpl.getShiftMap().get("5/13").getShiftTip().getTippers().get(0).getName(),
            testListNames.get(0).getName());
    assertEquals(testImpl.getShiftMap().get("5/13").getShiftTip().getTippers().get(2).getName(),
            testListNames.get(2).getName());
  }

  @Test
  public void removeShiftTest() {
    testImpl.addTipper("KO");
    testImpl.addTipper("Olivia");
    testImpl.addTipper("Sean");
    Tip testTipList = new Tip(testImpl.getTippers());


    ArrayList<Person> testListNames = new ArrayList<>();
    testListNames.add(new Person("KO"));
    testListNames.add(new Person("Olivia"));
    testListNames.add(new Person("Sean"));

    testImpl.addJob("Barback", 6);
    testImpl.addShift("5/12", "Single", 9, "Barback", testTipList,
            "rainy", "Morning");
    testImpl.addShift("5/13", "Single", 11, "Barback", testTipList,
            "sunny", "Morning");
    assertTrue(testImpl.getShiftMap().containsKey("5/12"));
    assertTrue(testImpl.getShiftMap().containsKey("5/13"));
    testImpl.removeShift("5/12");
    assertFalse(testImpl.getShiftMap().containsKey("5/12"));

  }
}