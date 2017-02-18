package com.example.emrea.hello;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emrea on 11/02/2017.
 */

public class Parsing {

    String[] getImageURLOfArtistSearch (String result) throws JSONException {

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

    String[] getArtistIDOfArtistSearch (String result) throws JSONException {
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

    String[] getAlbumImageURLOfAlbumSearchviaArtistID (String result) throws JSONException {
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

    String[] getAlbumNameOfAlbumSearchviaArtistID (String result) throws JSONException {
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

    String[] getAlbumImageURLOfAlbumSearch (String result) throws JSONException {
        int total = 0;
        JSONObject jsonresult = new JSONObject(result);
        total = jsonresult
                .getJSONObject("albums")
                .getInt("total");
        String[] albumImageURL = new String[50];
        for (int i = 0; i < 50; i++){
            int arr = jsonresult
                    .getJSONObject("albums")
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getJSONArray("images")
                    .length();
            if (arr > 0){
                albumImageURL[i] = jsonresult
                        .getJSONObject("albums")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getJSONArray("images")
                        .getJSONObject(arr - 1)
                        .getString("url");
            }
            else  { albumImageURL[i] = null; }
        }
        return albumImageURL;
    }

    String[] getAlbumNameOfAlbumSearch (String result) throws JSONException {
        int total = 0;
        JSONObject jsonresult = new JSONObject(result);
        total = jsonresult
                .getJSONObject("albums")
                .getInt("total");
        String[] albumName = new String[50];
        for (int i = 0; i < 50; i++){
            albumName[i] = jsonresult
                    .getJSONObject("albums")
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getString("name");
        }

        return albumName;
    }

    String[] getAlbumIDOfAlbumSearch (String result) throws JSONException {
        int total = 0;
        JSONObject jsonresult = new JSONObject(result);
        total = jsonresult
                .getJSONObject("albums")
                .getInt("total");
        String[] albumID = new String[50];
        for (int i = 0; i < 50; i++){
            albumID[i] = jsonresult
                    .getJSONObject("albums")
                    .getJSONArray("items")
                    .getJSONObject(i)
                    .getString("id");
        }

        return albumID;
    }
}
