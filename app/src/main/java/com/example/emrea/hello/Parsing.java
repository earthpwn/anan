package com.example.emrea.hello;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emrea on 11/02/2017.
 */

public class Parsing {

    String getImageURL (String result) throws JSONException {
        String imageurl = "";
        JSONObject jsonresult = new JSONObject(result);

        imageurl = jsonresult
                .getJSONObject("artists")
                .getJSONArray("items")
                .getJSONObject(0)
                .getJSONArray("images")
                .getJSONObject(2)
                .getString("url");

        return imageurl;
    }

    String getArtistName (String result) throws JSONException{
        String artistname = "";
        JSONObject jsonresult = new JSONObject(result);

        artistname = jsonresult
                .getJSONObject("artists")
                .getJSONArray("items")
                .getJSONObject(0)
                .getString("name");
        return artistname;
    }
}
