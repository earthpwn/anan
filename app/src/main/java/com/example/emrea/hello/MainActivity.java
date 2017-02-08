package com.example.emrea.hello;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.net.Uri;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;
import com.spotify.sdk.android.player.Config;
import com.spotify.sdk.android.player.ConnectionStateCallback;
import com.spotify.sdk.android.player.Error;
import com.spotify.sdk.android.player.Player;
import com.spotify.sdk.android.player.PlayerEvent;
import com.spotify.sdk.android.player.Spotify;
import com.spotify.sdk.android.player.SpotifyPlayer;

public class MainActivity extends AppCompatActivity implements
        SpotifyPlayer.NotificationCallback, ConnectionStateCallback
{
    String imageurl = null;
    public String getimg(){
        return imageurl;
    }
    // TODO: Replace with your client ID
    private static final String CLIENT_ID = "8d37a54bb27f446c915f3395cc1c9f4c";
    // TODO: Replace with your redirect URI
    private static final String REDIRECT_URI = "mycustomprotocol://callback";
    private static final String CLIENT_SECRET = "1e848a4467654d7292ae9a7c4858df5b";
    EditText emailText;
    TextView responseView;
    ProgressBar progressBar;
    private Player mPlayer;
    String token = "";
    String kod = "";
    String reftok = "AQCKkSAT5gRPFoNdxne3Hc3_BvR0rx9VlbRUJKIRFR17ITJj8zTdWS28KG2yAKpMlZpt_-PeWDzOJvXT6LT4Us5VHA8iK_knL27IRYR1rRMngNSR7ICd1IcKhDWEDd532e4";
    private static final int REQUEST_CODE = 1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseView = (TextView) findViewById(R.id.responseView);
        emailText = (EditText) findViewById(R.id.editText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        /*AuthenticationRequest.Builder builder = new AuthenticationRequest.Builder(CLIENT_ID,
                AuthenticationResponse.Type.TOKEN,
                REDIRECT_URI);
        builder.setScopes(new String[]{"user-read-private", "playlist-modify-private"});
        AuthenticationRequest request = builder.build();*/

        /*
        //authentication
        AuthenticationRequest request = new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.CODE, REDIRECT_URI)
                .setScopes(new String[]{"user-read-private", "playlist-modify-public", "playlist-modify-private","playlist-read-collaborative"})
                .build();
        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);*/

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RetrieveFeedTask().execute();
            }
        });
    }

    public void setImage (String url){
        try{
            ImageView i = (ImageView)findViewById(R.id.imageView);
            Bitmap bmp = BitmapFactory.decodeStream((InputStream)new URL (url).getContent());
            i.setImageBitmap(bmp);
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class RetrieveFeedTask extends AsyncTask<String, Void, String> {

        private Exception exception;
        Bitmap bmp = null;
        public String getimg(){
            return imageurl;
        }
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            responseView.setText("");
        }
        String email = emailText.getText().toString();

        protected String doInBackground(String... strings) {
            // Do some validation here




            try {
                URL nurl = new URL("https://api.spotify.com/v1/search?q=Opeth&type=artist");
                URL url = new URL("https://accounts.spotify.com/api/token" +
                        "?grant_type=refresh_token" +
                        "&refresh_token=" + reftok +
                        "&client_id=" + CLIENT_ID+
                        "&client_secret=" + CLIENT_SECRET);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                HttpURLConnection nurlConnection = (HttpURLConnection) nurl.openConnection();
                BufferedReader in = null;
                BufferedReader in2 = null;
                BufferedWriter out = null;
                String result = "";
                String result2 = "";

                try {

                    urlConnection.setDoInput(true);
                    urlConnection.setDoOutput(true);
                    //urlConnection.setRequestMethod("POST");

                    //urlConnection.setChunkedStreamingMode(0);
                    //urlConnection.setRequestProperty("Accept", "application/json");
                    //urlConnection.setRequestProperty("Authorization", "Bearer " + token);
                    //urlConnection.setRequestProperty("Content-type", "application/json");




                    /*JSONObject myjson = new JSONObject();
                    myjson.put("name", "anan");
                    myjson.put("public", "false");
                    String jsons = myjson.toString();*/

/*



                    urlConnection.connect();

                    out = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(),"UTF-8"));

                    out.write(jsons);

                    out.flush();*/
                    //out.close();
                    urlConnection.connect();
                    in = new BufferedReader(new InputStreamReader(
                            urlConnection.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null)
                        sb.append(line + "\n");


                    result = sb.toString();
                    System.out.println(result);

                    /*
                    //getting image url from search result

                    JSONObject jsonresult = new JSONObject(result);
                    JSONObject jsonartist = jsonresult.getJSONObject("artists");
                    JSONArray jsonitems = jsonartist.getJSONArray("items");
                    JSONObject jsonitem = jsonitems.getJSONObject(0);
                    JSONArray jsonimage = jsonitem.getJSONArray("images");
                    JSONObject jsonalbumimage = jsonimage.getJSONObject(2);
                    imageurl = jsonalbumimage.getString("url");*/

                    /*
                    //get refresh token (NO NEED)
                    JSONObject jresult = new JSONObject(result);
                    reftok = jresult.getString("refresh_token");
                    System.out.println("ananın tokenı" + reftok);*/

                    //get token
                    JSONObject jresult = new JSONObject(result);
                    token = jresult.getString("access_token");

                    nurlConnection.setRequestProperty("Accept", "application/json");
                    nurlConnection.setRequestProperty("Authorization", "Bearer " + token);
                    nurlConnection.setDoInput(true);
                    nurlConnection.setDoOutput(false);
                    nurlConnection.connect();
                    in2 = new BufferedReader(new InputStreamReader(
                            nurlConnection.getInputStream()));

                    StringBuilder sb2 = new StringBuilder();
                    String line2;
                    while ((line2 = in2.readLine()) != null)
                        sb2.append(line2 + "\n");


                    result2 = sb2.toString();
                    //System.out.println(result2);
                    JSONObject jsonresult = new JSONObject(result2);
                    JSONObject jsonartist = jsonresult.getJSONObject("artists");
                    JSONArray jsonitems = jsonartist.getJSONArray("items");
                    JSONObject jsonitem = jsonitems.getJSONObject(0);
                    JSONArray jsonimage = jsonitem.getJSONArray("images");
                    JSONObject jsonalbumimage = jsonimage.getJSONObject(2);
                    imageurl = jsonalbumimage.getString("url");
                    System.out.println(imageurl);

                    System.out.println (urlConnection.getResponseCode());
                    System.out.println (urlConnection.getResponseMessage());

                    return null;
                    /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();*/
                } finally {
                    //out.close();
                    in.close();
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if (response == null) {
                response = "THERE WAS AN ERROR";
            }

            Intent nextScreen = new Intent(MainActivity.this, myresult.class);
            nextScreen.putExtra("imagelink",imageurl);
            startActivity(nextScreen);
            /*Thread thread = new Thread(new Runnable() {
            ImageView i = null;

                public void run() {
                    try  {
                        //setContentView(R.layout.result); boyle olmuyo
                         i = (ImageView)findViewById(R.id.imageView);

                        bmp = BitmapFactory.decodeStream((InputStream)new URL(imageurl).getContent());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                i.setImageBitmap(bmp);

                            }
                        });


                        } catch (MalformedURLException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            thread.start();*/




            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);

            switch (response.getType()) {
                // Response was successful and contains auth token
                case CODE:
                    kod = response.getCode();
                    System.out.println (kod);
                case TOKEN:
                    Log.e("Login OLDU AQ", "WE ARE IN MADAFAKA");
                    token  = response.getAccessToken();

                    break;

                // Auth flow returned an error
                case ERROR:
                    Log.e("Auth error: ",  response.getError());
                    break;

                // Most likely auth flow was cancelled
                default:
                    Log.e("Login failed", response.getType().toString());
            }
        }
    }

    @Override
    protected void onDestroy() {
        Spotify.destroyPlayer(this);
        super.onDestroy();
    }

    @Override
    public void onPlaybackEvent(PlayerEvent playerEvent) {
        Log.d("MainActivity", "Playback event received: " + playerEvent.name());
        switch (playerEvent) {
            // Handle event type as necessary
            default:
                break;
        }
    }

    @Override
    public void onPlaybackError(Error error) {
        Log.d("MainActivity", "Playback error received: " + error.name());
        switch (error) {
            // Handle error type as necessary
            default:
                break;
        }
    }

    @Override
    public void onLoggedIn() {
        Log.d("MainActivity", "User logged in");

        //mPlayer.playUri(null, "spotify:track:2TpxZ7JUBn3uw46aR7qd6V", 0, 0);
    }

    @Override
    public void onLoggedOut() {
        Log.d("MainActivity", "User logged out");
    }

    @Override
    public void onLoginFailed(Error error) {
        Log.d("MainActivity", "Login failed");
    }

    @Override
    public void onTemporaryError() {
        Log.d("MainActivity", "Temporary error occurred");
    }

    @Override
    public void onConnectionMessage(String message) {
        Log.d("MainActivity", "Received connection message: " + message);
    }
}