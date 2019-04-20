package model;

public class Location implements ILocation{

    private String locationName;

    public Location(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String getLocationName() {
        return locationName;
    }

}
