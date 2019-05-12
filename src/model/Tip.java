package model;

import java.util.ArrayList;

public class Tip implements ITip {

  private ArrayList<Person> tipList;

  public Tip(ArrayList<Person> tipList) {
    this.tipList = tipList;
  }

  @Override
  public ArrayList<Person> getTippers() {
    return tipList;
  }
}
