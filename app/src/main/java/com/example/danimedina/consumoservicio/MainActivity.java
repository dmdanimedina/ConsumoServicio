package com.example.danimedina.consumoservicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import org.json.JSONException;
import cz.msebera.android.httpclient.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    public static String ruta = "http://betacode.cl/BetacodeLabsMasterRest/Master/public/Lovers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AsyncHttpClient client = new AsyncHttpClient();

        client.get(ruta,null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray pers = response.getJSONArray("data");
                    for(int i = 0; i<pers.length(); i++){
                        JSONObject c = pers.getJSONObject(i);
                        Log.d("_____DATA______",c.getString("nombrecompleto"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }});

    }

}
