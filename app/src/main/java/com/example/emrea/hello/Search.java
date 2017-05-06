package com.example.emrea.hello;

import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.id;

/**
 * Created by emrea on 14/02/2017.
 */

public class Search {
    String searchArtist(String token, String keyword) {
        String result = "";
        try{
            URL url = new URL("https://api.spotify.com/v1/search?q=" + keyword + "&type=artist&limit=50");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = null;
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(false);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            urlConnection.connect();

            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null)
                sb.append(line + "\n");

            result = sb.toString();
            in.close();
            urlConnection.disconnect();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    String getAlbumOfArtist (String token, String id) {
        String result = "";
        try{
            URL url = new URL("https://api.spotify.com/v1/artists/" + id + "/albums?limit=50");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in;
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(false);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            urlConnection.connect();

            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null)
                sb.append(line + "\n");

            result = sb.toString();
            in.close();
            urlConnection.disconnect();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    String searchAlbum(String token, String keyword) {
        String result ="";
        try{
            URL url = new URL("https://api.spotify.com/v1/search?q=" + keyword + "&type=album&limit=50");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = null;
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(false);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            urlConnection.connect();

            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null)
                sb.append(line + "\n");

            result = sb.toString();
            in.close();
            urlConnection.disconnect();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    String searchTrack(String token, String keyword) {
        String result ="";

        try{
            URL url = new URL("https://api.spotify.com/v1/search?q=" + keyword + "&type=track&limit=50");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = null;
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(false);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            urlConnection.connect();

            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null)
                sb.append(line + "\n");

            result = sb.toString();
            in.close();
            urlConnection.disconnect();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    String getTrackOfArtistviaAlbumID (String token, String id) {
        String result = "";

        try {
            URL url = new URL("https://api.spotify.com/v1/albums/" + id + "/tracks");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = null;
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(false);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            urlConnection.connect();

            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null)
                sb.append(line + "\n");

            result = sb.toString();
            in.close();
            urlConnection.disconnect();

        }catch (IOException e) {
                e.printStackTrace();
        }
        return result;
    }

}
