package com.example.emrea.hello;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by emrea on 14/02/2017.
 */

public class Login {
    String getToken() {
        String reftok = "AQCKkSAT5gRPFoNdxne3Hc3_BvR0rx9VlbRUJKIRFR17ITJj8zTdWS28KG2yAKpMlZpt_-PeWDzOJvXT6LT4Us5VHA8iK_knL27IRYR1rRMngNSR7ICd1IcKhDWEDd532e4";
        final String CLIENT_SECRET = "1e848a4467654d7292ae9a7c4858df5b";
        final String CLIENT_ID = "8d37a54bb27f446c915f3395cc1c9f4c";
        String token = "";

        try{
            BufferedReader in;
            URL url = new URL("https://accounts.spotify.com/api/token" +
                    "?grant_type=refresh_token" +
                    "&refresh_token=" + reftok +
                    "&client_id=" + CLIENT_ID+
                    "&client_secret=" + CLIENT_SECRET);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            String result = "";
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null)
                sb.append(line + "\n");


            result = sb.toString();
            System.out.println(result);
            JSONObject jresult = new JSONObject(result);
            token = jresult.getString("access_token");
            System.out.println (urlConnection.getResponseCode());
            System.out.println (urlConnection.getResponseMessage());

            in.close();
            urlConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return token;
    }


}
