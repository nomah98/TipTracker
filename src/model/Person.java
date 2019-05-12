package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Person implements IPerson {

    private String name;
    private HashMap<String, Integer> tipperMap = new HashMap<>();


    public Person(String name) {
        this.name = name;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public HashMap<String, Integer> getTipperMap() {
        return tipperMap;
    }

}
