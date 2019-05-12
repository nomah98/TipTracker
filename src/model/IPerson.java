package model;

import java.util.Map;

public interface IPerson {

    /**
     * Return the name of this Person.
     *
     * @return Person name
     */
    String getName();

    /**
     * Returns the map of tipper
     * @return  Map<String, Integer> of the date as a string to how much they tipped
     */
    Map<String, Integer> getTipperMap();

}
