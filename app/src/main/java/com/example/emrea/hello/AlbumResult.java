package com.example.emrea.hello;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;

import java.io.IOException;

public class AlbumResult extends AppCompatActivity {

    String token;
    String[] albumID =  {};
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
                String searchType = in.getStringExtra("searchType");
                token = in.getStringExtra("token");
                // is an album searched from MainActivity ?
                if(searchType.matches("album")){
                    String searchWord = in.getStringExtra("search");
                    //do search
                    String result = "";
                    Search newSearch = new Search();
                    result = newSearch.searchAlbum(token, searchWord);

                    //Parse result
                    Parsing parser = new Parsing();
                    imageurl = parser.getAlbumImageURLOfAlbumSearch(result);
                    albumname = parser.getAlbumNameOfAlbumSearch(result);
                    albumID = parser.getAlbumIDOfAlbumSearch(result);
                }
                // or albums of an artist need to be listed ?
                else{
                    String artistID = in.getStringExtra("id");


                    //do search
                    String result = "";
                    Search newSearch = new Search();
                    result = newSearch.getAlbumOfArtist(token, artistID);

                    //Parse result
                    Parsing parser = new Parsing();
                    imageurl = parser.getAlbumImageURLOfAlbumSearchviaArtistID(result);
                    albumname = parser.getAlbumNameOfAlbumSearchviaArtistID(result);
                    albumID = parser.getAlbumIDOfAlbumSearchviaArtistID(result);
                }




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
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView parent, View v, int position, long id){
                    Intent nextScreen = new Intent(AlbumResult.this, TrackResult.class);
                    nextScreen.putExtra("token",token);
                    nextScreen.putExtra("searchType","id");
                    nextScreen.putExtra("id",albumID[position]);
                    startActivity(nextScreen);
                }
            });
        }
    }


}