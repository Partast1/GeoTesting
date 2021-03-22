package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class APIHandler {
    static String APIKEY = "?access_key=31e2be8211fe8f0782a0fb0a57c012c8";
    static String searchQuery = "&query=";
    static String address = "";
    static String APIURL = "http://api.positionstack.com/v1/forward";

    public void GetAddress(String addressName) throws IOException {
        address = addressName;

    }
        public void GetAPILocationInformation(String addressName) throws IOException {
            Reading reading = new Reading();

            URL url = new URL(APIURL + APIKEY + searchQuery+ addressName);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine = null;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {

                response.append(inputLine);
            }
            in.close();
            try {
                ObjectMapper om = new ObjectMapper();
                reading = om.readValue(response.toString(), Reading.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            con.disconnect();
            System.out.println("Testing" + response.toString());
            for (int i = 0; i > reading.data.size(); i ++){
                System.out.print("hej med dig" + reading.data.toString());
            }

        }
}
