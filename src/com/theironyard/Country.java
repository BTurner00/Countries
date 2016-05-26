package com.theironyard;

/**
 * Created by Ben on 5/26/16.
 */
public class Country {
    String name;
    String abbrev;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public Country (String name, String abbrev) {

        this.abbrev = abbrev;
        this.name = name;
    }
}
