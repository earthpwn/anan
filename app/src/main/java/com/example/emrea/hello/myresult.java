package com.example.emrea.hello;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.emrea.hello.MainActivity;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.example.emrea.hello.R.layout.listview;

public class myresult extends AppCompatActivity {

    ListView listView;
    String[] artistID =  {};
    String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myresult);
        listView = (ListView) findViewById(R.id.liste);
        final Context context = this;



        /*final String myurl = in.getStringExtra("imagelink");

        Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {


                    try  {

                        System.out.println(myurl);
                        final ImageView i = (ImageView)findViewById(R.id.imageView2);
                        final Bitmap bmp = BitmapFactory.decodeStream((InputStream)new URL(myurl).getContent());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                i.setImageBitmap(bmp);

                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally{

                    }
                }
            });
            thread.start();*/


        //View vg = findViewById (R.id.activity_myresult);
        //vg.invalidate();
        //Tospaa made this.

        /*
        Intent in = getIntent();
        String searchWord = in.getStringExtra("search");
        String token = in.getStringExtra("token");
        String result = "";
        Search newSearch = new Search();
        try {
            result = newSearch.searchArtist(token, searchWord);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parsing parser = new Parsing();
        String[] imageurl = {};
        String[] artistname = {};
        try {
            imageurl = parser.getImageURL(result);
            artistname = parser.getArtistName(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecipeAdapter adapter = new RecipeAdapter(this,
                artistname, imageurl);

        ListView listView = (ListView) findViewById(R.id.liste);
        listView.setAdapter(adapter);*/

        new getSearchResults().execute();

    }


    class getSearchResults extends AsyncTask<Void, Void, Void> {
        String[] imageurl = {};
        String[] artistname = {};
        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Void doInBackground(Void... param){
            try {
                //get passed variables
                Intent in = getIntent();
                String searchWord = in.getStringExtra("search");
                token = in.getStringExtra("token");

                //do search
                String result = "";
                Search newSearch = new Search();
                result = newSearch.searchArtist(token, searchWord);

                //Parse result
                Parsing parser = new Parsing();
                imageurl = parser.getImageURLofArtistSearch(result);
                artistname = parser.getArtistNameOfArtistSearch(result);
                artistID = parser.getArtistIDOfArtisSearch(result);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void param){
            RecipeAdapter adapter = new RecipeAdapter(myresult.this,
                    artistname, imageurl);

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView parent, View v, int position, long id){
                    Intent nextScreen = new Intent(myresult.this, AlbumResult.class);
                    nextScreen.putExtra("token",token);
                    nextScreen.putExtra("id", artistID[position]);
                    startActivity(nextScreen);
                }
            });
        }
    }


}
