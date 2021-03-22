package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;

public class SerializationTest {
    String json = "{\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"latitude\": 55.42821122,\n" +
            "            \"longitude\": 11.78459422,\n" +
            "            \"type\": \"address\",\n" +
            "            \"name\": \"Ahorn Alle 5\",\n" +
            "            \"number\": \"5\",\n" +
            "            \"postal_code\": \"4100\",\n" +
            "            \"street\": \"Ahorn Alle\",\n" +
            "            \"confidence\": 1,\n" +
            "            \"region\": \"Zealand\",\n" +
            "            \"region_code\": \"SL\",\n" +
            "            \"county\": null,\n" +
            "            \"locality\": \"Ringsted\",\n" +
            "            \"administrative_area\": \"Ringsted\",\n" +
            "            \"neighbourhood\": null,\n" +
            "            \"country\": \"Denmark\",\n" +
            "            \"country_code\": \"DNK\",\n" +
            "            \"continent\": \"Europe\",\n" +
            "            \"label\": \"Ahorn Alle 5, Ringsted, Denmark\"\n" +
            "        }\n" +
            "    ]\n" +
            "}" ;

    public void TestingSerialization(){
        Reading reading = new Reading();
        try {
            ObjectMapper om = new ObjectMapper();
            reading = om.readValue(json.toString(), Reading.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GetLocation(reading);

//        for (APIObject name : reading.data) {
//            System.out.println(name.latitude);
//        }
    }
    public void GetLocation(Reading reading){
        Location location = new Location();

        for (APIObject name : reading.data) {
            location.setLatitude(name.latitude);
            location.setLongitude(name.longitude);
        }

        System.out.println("Lati: " + location.getLatitude() + " Long: " + location.getLongitude());
        SaveToDatabase(location);
    }
//    public void SaveToDatabase(Reading reading){
//
//    }
    String constring = "127.0.0.1:3306;Database=TestDB;Uid=root;Pwd=I1LuMinAt1!";
    public Connection Connect(){
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/TestDB","root","I1LuMinAt1!");
            return con;
        }catch(Exception e){ System.out.println(e);}


        return null;
    }
    public void SaveToDatabase(Location location){

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        System.out.println("Lati: " + location.getLatitude() + " Long: " + location.getLongitude());
        Connection con = Connect();
        try{
            Statement statement=con.createStatement();

            statement.executeUpdate("INSERT INTO `Koor` (lat, lng) VALUE ('"+latitude+"','"+longitude+"')");

            con.close();
        }catch(Exception e){ System.out.println(e);}


    }
}
