package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    @JsonProperty("longitude")
    public double longitude;
    @JsonProperty("latitude")
    public double latitude;

}
