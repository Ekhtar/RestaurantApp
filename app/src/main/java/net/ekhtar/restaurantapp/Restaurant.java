package net.ekhtar.restaurantapp;

/**
 * Created by Hossam Magdy on 12/6/2017.
 */

public class Restaurant {
    private String name;
    private String phoneNumber;
    private String place;

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
