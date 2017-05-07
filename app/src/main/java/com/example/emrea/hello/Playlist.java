package com.example.emrea.hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by emrea on 07/05/2017.
 */

public class Playlist {

    // TODO: Spotify API responses to request below with a JSON data consist of a snapshot_id of added track. That snapshot_ids might be used to remove temporarily added tracks.
    void addTrack (String token, String trackID) {
        String result ="";

        try{
            URL url = new URL("https://api.spotify.com/v1/users/ananzaa666/playlists/1aZF6uupzQmXo9y1XP3Ewe/tracks?uris=spotify%3Atrack%3A" + trackID);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = null;
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();


            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null)
                sb.append(line + "\n");

            result = sb.toString();
            in.close();
            System.out.println (urlConnection.getResponseCode());
            System.out.println (urlConnection.getResponseMessage());
            urlConnection.disconnect();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
