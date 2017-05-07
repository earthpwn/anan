package com.example.emrea.hello;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emrea on 11/02/2017.
 */

public class Parsing {

    String[] getImageURLOfArtistSearch (String result) {
        String[] imageurl = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);

            total = jsonresult
                    .getJSONObject("artists")
                    .getInt("total");

            imageurl = new String[50];

            for (int i = 0; i < 50; i++) {
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
                            .getJSONObject(arr - 1)
                            .getString("url");
                } else {
                    imageurl[i] = null;
                }

            }
        }catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }
        return imageurl;
    }

    String[] getArtistNameOfArtistSearch (String result) {
        String[] artistname = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getJSONObject("artists")
                    .getInt("total");
            artistname = new String[50];
            for (int i = 0; i < 50; i++) {
                artistname[i] = jsonresult
                        .getJSONObject("artists")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("name");
            }
        }catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }

        return artistname;
    }

    String[] getArtistIDOfArtistSearch (String result) {
        String[] artistID = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getJSONObject("artists")
                    .getInt("total");
            artistID = new String[50];
            for (int i = 0; i < 50; i++) {
                artistID[i] = jsonresult
                        .getJSONObject("artists")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("id");
            }
        }catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }
        return artistID;
    }

    String[] getAlbumImageURLOfAlbumSearchviaArtistID (String result) {
        String[] imageurl = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getInt("total");
            imageurl = new String[50];
            for (int i = 0; i < 50; i++) {
                int arr = jsonresult
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getJSONArray("images")
                        .length();
                if (arr > 0) {
                    imageurl[i] = jsonresult
                            .getJSONArray("items")
                            .getJSONObject(i)
                            .getJSONArray("images")
                            .getJSONObject(arr - 1)
                            .getString("url");
                } else {
                    imageurl[i] = null;
                }
            }
        }catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }
        return imageurl;
    }

    String[] getAlbumNameOfAlbumSearchviaArtistID (String result) {
        String[] albumname = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getInt("total");
            albumname = new String[50];
            for (int i = 0; i < 50; i++) {
                albumname[i] = jsonresult
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("name");
            }
        }catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }

        return albumname;
    }

    String[] getAlbumImageURLOfAlbumSearch (String result) {
        String[] albumImageURL = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getJSONObject("albums")
                    .getInt("total");
            albumImageURL = new String[50];
            for (int i = 0; i < 50; i++) {
                int arr = jsonresult
                        .getJSONObject("albums")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getJSONArray("images")
                        .length();
                if (arr > 0) {
                    albumImageURL[i] = jsonresult
                            .getJSONObject("albums")
                            .getJSONArray("items")
                            .getJSONObject(i)
                            .getJSONArray("images")
                            .getJSONObject(arr - 1)
                            .getString("url");
                } else {
                    albumImageURL[i] = null;
                }
            }
        }catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }

        return albumImageURL;
    }

    String[] getAlbumNameOfAlbumSearch (String result) {
        String[] albumName = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getJSONObject("albums")
                    .getInt("total");
            albumName = new String[50];
            for (int i = 0; i < 50; i++) {
                albumName[i] = jsonresult
                        .getJSONObject("albums")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("name");
            }
        }catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }

        return albumName;
    }

    String[] getAlbumIDOfAlbumSearch (String result) {
        String[] albumID = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getJSONObject("albums")
                    .getInt("total");
            albumID = new String[50];
            for (int i = 0; i < 50; i++) {
                albumID[i] = jsonresult
                        .getJSONObject("albums")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("id");
            }
        }catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }

        return albumID;
    }

    String[] getTrackImageURLOfTrackSearch (String result){
        String[] trackImageURL = null;
        try{
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getJSONObject("tracks")
                    .getInt("total");
            trackImageURL = new String[50];
            for (int i = 0; i < 50; i++){
                int arr = jsonresult
                        .getJSONObject("tracks")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getJSONObject("album")
                        .getJSONArray("images")
                        .length();
                if (arr > 0){
                    trackImageURL[i] = jsonresult
                            .getJSONObject("tracks")
                            .getJSONArray("items")
                            .getJSONObject(i)
                            .getJSONObject("album")
                            .getJSONArray("images")
                            .getJSONObject(arr - 1)
                            .getString("url");
                }
                else  { trackImageURL[i] = null; }
            }

        } catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }
        return trackImageURL;
    }

    String[] getTrackNameOfTrackSearch (String result) {
        String[] trackName = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getJSONObject("tracks")
                    .getInt("total");
            trackName = new String[50];
            for (int i = 0; i < 50; i++) {
                trackName[i] = jsonresult
                        .getJSONObject("tracks")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("name");
            }

        } catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }
        return trackName;
    }

    String[] getTrackIDOfTrackSearch (String result) {
        String[] trackName = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getJSONObject("tracks")
                    .getInt("total");
            trackName = new String[50];
            for (int i = 0; i < 50; i++) {
                trackName[i] = jsonresult
                        .getJSONObject("tracks")
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("id");
            }

        } catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }
        return trackName;
    }

    String[] getTrackNameOfTrackSearchviaAlbumID (String result) {
        String[] trackname = null;
        try {
            int total = 0;
            JSONObject jsonresult = null;
            jsonresult = new JSONObject(result);
            total = jsonresult
                    .getInt("total");
            trackname = new String[total];
            for (int i = 0; i < total; i++){
                trackname[i] = jsonresult
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("name");
            }
        } catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }

        return trackname;
    }

    String[] getAlbumIDOfAlbumSearchviaArtistID (String result) {
        String[] trackID = null;
        try {
            int total = 0;
            JSONObject jsonresult = new JSONObject(result);
            total = jsonresult
                    .getInt("total");
            trackID = new String[50];
            for (int i = 0; i < 50; i++) {
                trackID[i] = jsonresult
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("id");
            }
        }catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }
        return trackID;
    }

    String[] getTrackIDOfTrackSearchviaAlbumID (String result) {
        String[] trackID = null;
        try {
            int total = 0;
            JSONObject jsonresult = null;
            jsonresult = new JSONObject(result);
            total = jsonresult
                    .getInt("total");
            trackID = new String[total];
            for (int i = 0; i < total; i++){
                trackID[i] = jsonresult
                        .getJSONArray("items")
                        .getJSONObject(i)
                        .getString("id");
            }
        } catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }

        return trackID;
    }

    int getNumberOfTracksOfAlbumviaAlbumID (String result){
        int numberOfTracks = 0;
        try {
            JSONObject jsonresult = null;
            jsonresult = new JSONObject(result);
            numberOfTracks = jsonresult
                    .getInt("total");
        } catch (JSONException e) {
            Log.e("empty", "JSON or its sub-branches given to parser is null");
        }
        return numberOfTracks;
    }

}
