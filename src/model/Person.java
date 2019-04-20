package model;

public class Person implements IPerson {

    private IPerson person;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
