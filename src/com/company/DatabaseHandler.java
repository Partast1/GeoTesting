package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    String constring = "127.0.0.1:3306;Database=TestDB;Uid=root;Pwd=P@ssW0rd";
    public Connection Connect(){
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/TestDB","root","P@ssW0rd");
            return con;
        }catch(Exception e){ System.out.println(e);}


        return null;
    }
    public void ReadPosition(){

            Connection con = Connect();
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from Koor");
                while(rs.next())
                    System.out.println("Lati:" + rs.getString(1)+"  "+ "Long:" + rs.getString(2));
                con.close();
            }catch(Exception e){ System.out.println(e);}
    }
    //Finder alle brugere og kommer dem i en liste
    public void GetUsers(){
        Connection con = Connect();
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select CPRNumberPK, Firstname, Middelname, Surname, Streetname, phonenumber from Person");

            List<User> people = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setCPRnumber(rs.getInt("CPRNumberPK"));
                user.setFirstname(rs.getString("Firstname"));
                user.setMiddelname(rs.getString("Middelname"));
                user.setSirname(rs.getString("Surname"));
                user.setAddress(rs.getString("Streetname"));
                user.setPhonenumber(rs.getInt("phonenumber"));
                people.add(user);
            }
            con.close();
            for (User person : people
            ) {
                System.out.println(person.getCPRnumber() + person.getFirstname() + person.getMiddelname() + person.getSirname() + person.getAddress() + person.getPhonenumber());
            }
        }catch(Exception e){ System.out.println(e);}
    }
    //Søger på en specifik bruger ud fra cpr nummer.
    public void GetSpecificUser(int CprNumber){
        Connection con = Connect();
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select CPRNumberPK, Firstname, Middelname, Surname, Streetname, phonenumber from Person where CPRNumberPK =" + CprNumber);
            while (rs.next()) {
                User user = new User();
                user.setCPRnumber(rs.getInt("CPRNumberPK"));
                user.setFirstname(rs.getString("Firstname"));
                user.setMiddelname(rs.getString("Middelname"));
                user.setSirname(rs.getString("Surname"));
                user.setAddress(rs.getString("Streetname"));
                user.setPhonenumber(rs.getInt("phonenumber"));
                System.out.println(user.getCPRnumber() + user.getFirstname() + user.getMiddelname() + user.getSirname() + user.getAddress() + user.getPhonenumber());
            }
            con.close();

        }catch(Exception e){ System.out.println(e);}
    }
    //Søger på en specifik bruger ud fra cpr nummer.
    public void GetCoordinatesForSpecificUser(int CprNumber){
        Connection con = Connect();
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT Latitude, Longitude, CPRNumberPK FROM Person person JOIN Addresspostal address ON person.PostalFK=address.PostalnumberPK JOIN Coordinates coor ON address.CoordinatesFK=coor.ID WHERE CPRNumberPK = " + CprNumber);

            while (rs.next()) {
                Location location = new Location();

                location.setLatitude(rs.getDouble("Latitude"));
                location.setLongitude(rs.getDouble("Longitude"));
                System.out.println(location.getLatitude() + "test" + location.getLongitude() );
            }
            con.close();

        }catch(Exception e){ System.out.println(e);}
    }
}
