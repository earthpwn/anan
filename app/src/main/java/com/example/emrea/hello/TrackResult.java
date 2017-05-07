package com.example.emrea.hello;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    String token;
    String idOfSelectedTrack;

    class TrackResults extends AsyncTask<Void, Void, Void> {
        String[] trackname = {};
        String[] trackID = {};
        String[] imageurl = {};

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Void doInBackground(Void... param) {

            //get passed variables
            Intent in = getIntent();
            String searchType = in.getStringExtra("searchType");

            token = in.getStringExtra("token");

            // Is a track searched from MainActivity ?
            if(searchType.matches("track")){
                String keyWord = in.getStringExtra("search");
                //do search
                String result = "";
                Search newSearch = new Search();
                result = newSearch.searchTrack(token, keyWord);

                //Parse result
                Parsing parser = new Parsing();
                trackname = parser.getTrackNameOfTrackSearch(result);
                trackID = parser.getTrackIDOfTrackSearch(result);
                imageurl = parser.getTrackImageURLOfTrackSearch(result);
            }
            // or an album's tracks need to be listed ?
            else{
                String albumID = in.getStringExtra("id");
                //do search
                String result = "";
                Search newSearch = new Search();
                result = newSearch.getTrackOfArtistviaAlbumID(token, albumID);

                //Parse result
                Parsing parser = new Parsing();
                trackname = parser.getTrackNameOfTrackSearchviaAlbumID(result);
                trackID = parser.getTrackIDOfTrackSearchviaAlbumID(result);
                int not = parser.getNumberOfTracksOfAlbumviaAlbumID(result);
                imageurl = new String[not];
                for(int i = 0; i < not; i++){
                    imageurl[i] = in.getStringExtra("imageURL");
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void param){
            RecipeAdapter adapter = new RecipeAdapter(TrackResult.this,
                    trackname, imageurl);

            ListView listView = (ListView) findViewById(R.id.liste);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView parent, View v, int position, long id){
                    idOfSelectedTrack = trackID[position];
                    new AddTrack().execute();
                }
            });
        }
    }

    class AddTrack extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Void doInBackground(Void... param) {
            Playlist playlist = new Playlist();
            playlist.addTrack(token, idOfSelectedTrack);

            return null;
        }
        @Override
        protected void onPostExecute(Void param){

        }
    }
}