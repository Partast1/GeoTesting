package com.company;

public class GPS_Distance_Calculator {
    //Tager 2 GPS koordinator og udregner længden imellem disse.
    public double CalculateDistance(double lat1,double lon1,double lat2,double lon2){

        //Sikre at koordinatoerne ikke er 0
        if ((lat1 == 0) && (lat2 == 0)) {
            return 0;
        }
        else {
            //Omregner longitude til Radians
            double longiRadians = Math.cos(Math.toRadians((lon1 - lon2)));
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * longiRadians;
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            //Omregnes til kilometer
            dist = dist * 1.609344;

            return (dist);
        }

    }
}
