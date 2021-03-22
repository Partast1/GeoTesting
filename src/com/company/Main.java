package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {


    static double lati1 = 55.428211;
    static double longi1 = 11.784594;
    static double Latitude = 55.438823;
    static double Longitude = 11.78713;

    public static void main(String[] args) throws IOException {
//        System.out.println("Hej test2");

//        data.setLatitude(lati);
//        data.setLongitude(longi);
//        System.out.println(" latitude= " + data.getLatitude() + " longitude= " + data.getLongitude());
//        GPS_Distance_Calculator distanceCalc = new GPS_Distance_Calculator();
//        double distance = 0;

//        System.out.println(distance);

//        APIHandler apiHandler = new APIHandler();
//        apiHandler.GetAPILocationInformation("Ringsted");

        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.GetCoordinatesForSpecificUser(1201856353);

//        SerializationTest sTest = new SerializationTest();
//        sTest.TestingSerialization();
//        User user = new User("Anders", "Møller", "Andersen", "Ahorn alle 5", 88888888, 3 );
//        ThreatDecreaser threatDecreaser = new ThreatDecreaser();
//        threatDecreaser.Decrease(user);
//        System.out.println(user.getThreatlevel());


        System.in.read();
    }


}
