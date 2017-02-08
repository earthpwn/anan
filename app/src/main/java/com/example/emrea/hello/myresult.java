package com.example.emrea.hello;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.emrea.hello.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class myresult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myresult);


        Intent in = getIntent();
        final String myurl = in.getStringExtra("imagelink");

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
            thread.start();
        //View vg = findViewById (R.id.activity_myresult);
        //vg.invalidate();

        String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.liste);
        listView.setAdapter(adapter);
    }
}
