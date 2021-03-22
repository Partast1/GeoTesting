package com.company;

public class User {
    private int CPRnumber;
    private String Firstname;
    private String Middelname;
    private String Sirname;
    private String Address;
    private int Phonenumber;
    private int Threatlevel;


    //Getters
    public int getCPRnumber() {
        return CPRnumber;
    }
    public String getFirstname() {
        return Firstname;
    }
    public String getMiddelname() {
        return Middelname;
    }
    public String getSirname() {
        return Sirname;
    }
    public String getAddress() {
        return Address;
    }
    public int getPhonenumber() {
        return Phonenumber;
    }
    public int getThreatlevel() {
        return Threatlevel;
    }
    //Setters
    public void setCPRnumber(int CPRnumber) {
        this.CPRnumber = CPRnumber;
    }
    public void setFirstname(String name) {
        Firstname = name;
    }
    public void setMiddelname(String middelname) {
        Middelname = middelname;
    }
    public void setSirname(String sirname) {
        Sirname = sirname;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public void setPhonenumber(int phonenumber) {
        Phonenumber = phonenumber;
    }
    public void setThreatlevel(int threatlevel) {
        Threatlevel = threatlevel;
    }
    //Constructor
    public User(int CPRnumber, String name, String middelname, String sirname, String address, int phonenumber, int threatlevel) {
        setCPRnumber(CPRnumber);
        setFirstname(name);
        setMiddelname(middelname);
        setSirname(sirname);
        setAddress(address);
        setPhonenumber(phonenumber);
        setThreatlevel(threatlevel);
    }
    public User(){

    }
}
