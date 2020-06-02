package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;

public class detail extends AppCompatActivity {
    private RequestQueue requestQueue;
    public TextView judul_detail;
    public ImageView gambar_detail;
    public TextView harga_detail;
    public TextView deskripsi_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        judul_detail = findViewById(R.id.judul_detail);
        harga_detail = findViewById(R.id.harga_detail);
        deskripsi_detail = findViewById(R.id.deskripsi_detail);
        gambar_detail = findViewById(R.id.img_detail);

        String produkid = getIntent().getStringExtra("produkid");
        requestQueue = Volley.newRequestQueue(this);

        String url = "http://dekguh.com/json_mp/api.php?produkid="+produkid;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject data = response.getJSONObject(0);
                            String gambarmenu = data.getString("gambar");
                            String namamenu = data.getString("nama");
                            String hargamenu = data.getString("harga");
                            String idmenu = data.getString("id");
                            String deskripsimenu = data.getString("deskripsi");

                            judul_detail.setText(namamenu);
                            harga_detail.setText(hargamenu);
                            deskripsi_detail.setText(deskripsimenu);

                            Glide
                                    .with(detail.this)
                                    .load(gambarmenu)
                                    .centerCrop()
                                    .into(gambar_detail);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

    public void parseData() {

    }
}
