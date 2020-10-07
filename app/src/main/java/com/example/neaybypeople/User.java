package com.example.neaybypeople;

public class User {

    public String username;
    public String email;
    public double latitude;
    public double longitude;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username) {
        this.username = username;
    }
    public void setLocation(double latitue,double longitude){
        this.latitude = latitue;
        this.longitude = longitude;
    }

}
