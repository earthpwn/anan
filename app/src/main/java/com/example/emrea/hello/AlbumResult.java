package com.example.emrea.hello;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONException;

import java.io.IOException;

public class AlbumResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_result);
        new AlbumResults().execute();
    }

    class AlbumResults extends AsyncTask<Void, Void, Void> {
        String[] imageurl = {};
        String[] albumname = {};
        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Void doInBackground(Void... param){
            try {
                //get passed variables
                Intent in = getIntent();
                String albumid = in.getStringExtra("id");
                String token = in.getStringExtra("token");

                //do search
                String result = "";
                Search newSearch = new Search();
                result = newSearch.getAlbumOfArtist(token, albumid);

                //Parse result
                Parsing parser = new Parsing();
                imageurl = parser.getAlbumImageURLOfAlbumSearchviaArtistID(result);
                albumname = parser.getAlbumNameOfAlbumSearchviaArtistID(result);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void param){
            RecipeAdapter adapter = new RecipeAdapter(AlbumResult.this,
                    albumname, imageurl);

            ListView listView = (ListView) findViewById(R.id.liste);
            listView.setAdapter(adapter);

        }
    }
}
