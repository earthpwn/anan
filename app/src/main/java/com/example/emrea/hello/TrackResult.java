package com.example.emrea.hello;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONException;

import java.io.IOException;

public class TrackResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_result);
        new TrackResults().execute();
    }

    class TrackResults extends AsyncTask<Void, Void, Void> {
        String[] trackname = {};
        String[] imageurl = new String[1];
        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Void doInBackground(Void... param) {

            try {
                //get passed variables
                Intent in = getIntent();
                String trackid = in.getStringExtra("id");
                String token = in.getStringExtra("token");
                imageurl[0] = "https://i.scdn.co/image/85236cc12312fac9405206c25bd38479e63a04d6";
                //String imageurl = in.getStringExtra("imageURL");
                // TODO: AlbumResult'tan ImageURL pasla

                //do search
                String result = "";
                Search newSearch = new Search();
                result = newSearch.getTrackOfArtistviaAlbumID(token, trackid);

                //Parse result
                Parsing parser = new Parsing();
                trackname = parser.getTrackNameOfTrackSearchviaAlbumID(result);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void param){
            RecipeAdapter adapter = new RecipeAdapter(TrackResult.this,
                    trackname, imageurl);

            ListView listView = (ListView) findViewById(R.id.liste);
            listView.setAdapter(adapter);
        }
    }
}