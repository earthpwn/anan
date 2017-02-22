package com.example.emrea.hello;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emrea on 11/02/2017.
 */

public class Parsing {

    String[] getImageURLofArtistSearch (String result) throws JSONException {

        int total = 0;
        JSONObject jsonresult = new JSONObject(result);

        total = jsonresult
                .getJSONObject("artists")
                .getInt("total");

        String[] imageurl = new String[50];

        for(int i = 0; i < 50; i++) {
            int arr = jsonresult
                    .getJSONObject("artists")
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getJSONArray("images")
                    .length();
            if (arr > 0) {
                imageurl[i] = jsonresult
                        .getJSONObject("artists")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getJSONArray("images")
                        .getJSONObject(arr-1)
                        .getString("url");
            }
            else{   imageurl[i] = null; }

            }
        return imageurl;
    }

    String[] getArtistNameOfArtistSearch (String result) throws JSONException{
        int total = 0;
        JSONObject jsonresult = new JSONObject(result);
        total = jsonresult
                .getJSONObject("artists")
                .getInt("total");
        String[] artistname = new String[50];
        for (int i = 0; i < 50; i++){
            artistname[i] = jsonresult
                    .getJSONObject("artists")
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getString("name");
            }

        return artistname;
    }

    String[] getArtistIDOfArtisSearch (String result) throws JSONException {
        int total = 0;
        JSONObject jsonresult = new JSONObject(result);
        total = jsonresult
                .getJSONObject("artists")
                .getInt("total");
        String[] artistID = new String[50];
        for(int i = 0; i < 50; i++){
            artistID[i] = jsonresult
                    .getJSONObject("artists")
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getString("id");
        }
        return artistID;
    }

    String[] getAlbumImageURLOfAlbumSearch (String result) throws JSONException {
        int total = 0;
        JSONObject jsonresult = new JSONObject(result);
        total = jsonresult
                .getInt("total");
        String[] imageurl = new String[50];
        for(int i = 0; i < 50; i++){
            int arr = jsonresult
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getJSONArray("images")
                    .length();
            if(arr > 0){
                imageurl[i] = jsonresult
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getJSONArray("images")
                        .getJSONObject(arr - 1)
                        .getString("url");
            }
            else {
                imageurl[i] = null;
            }
        }
        return imageurl;
    }

    String[] getAlbumNameOfAlbumSearch (String result) throws JSONException {
        int total = 0;
        JSONObject jsonresult = new JSONObject(result);
        total = jsonresult
                .getInt("total");
        String[] albumname = new String[50];
        for (int i = 0; i < 50; i++){
            albumname[i] = jsonresult
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getString("name");
        }
        return albumname;
    }

    String[] getTrackNameOfTrackSearchviaAlbumID (String result) throws JSONException {
        int total = 0;
        JSONObject jsonresult = new JSONObject(result);
        total = jsonresult
                .getInt("total");
        String[] trackname = new String[50];
        for (int i = 0; i < 50; i++){
            trackname[i] = jsonresult
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getString("name");
        }
        return trackname;
    }

    String[] getAlbumIDOfAlbumSearchviaArtistID (String result) throws JSONException {
        int total = 0;
        JSONObject jsonresult = new JSONObject(result);
        total = jsonresult
                .getInt("total");
        String[] albumname = new String[5];
        for (int i = 0; i < 5; i++){
            albumname[i] = jsonresult
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getString("id");
        }
        return albumname;


}
}
