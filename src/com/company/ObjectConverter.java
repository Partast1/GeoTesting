package com.company;

public class ObjectConverter {
    //Får et reading object, her tages lokationsinformationerne og derefter oprettes en ny "Location"
    public void Convert(Reading reading){
        Location location = new Location();

        for (APIObject name : reading.data) {
            location.setLatitude(name.latitude);
            location.setLongitude(name.longitude);
        }

        System.out.println("Lati: " + location.getLatitude() + " Long: " + location.getLongitude());
    }
}
