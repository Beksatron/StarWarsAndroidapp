package com.example.androidwarsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainScreenActivity extends AppCompatActivity implements RecyclerItemClickListener.OnRecyclerClickListener {


    private static final String TAG = "MainSCREENActivity";
    private RecyclerView mRecyclerView;
    private ExAdapter mExAdapter;
    private ArrayList<People> mItemList;
    private RequestQueue mRequestQueue;
    String name;
    String height;
    String mass;
    String films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, mRecyclerView, this));

        mItemList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJson();


        Log.d(TAG, "onCreate: ends");
    }

//   kod ispod koristan za testiranje
//    @Override
//    public void onBackPressed() {
////        super.onBackPressed();
//    }


    private void parseJson() {

        String url = "https://swapi.dev/api/people/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: Starts DOWNLOAD");
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);


                                name = result.getString("name");
                                height = result.getString("height");
                                mass = result.getString("mass");
//                                tbc...
                                films = result.getString("films");

                                Log.d(TAG, "onResponse: films are : " + films);
                                mItemList.add(new People(name, height, mass, films));
                            }

                            mExAdapter = new ExAdapter(MainScreenActivity.this, mItemList);
                            mRecyclerView.setAdapter(mExAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e(TAG, "onResponse: ERROR: " + e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(View view, int position) {
       mItemList.get(position);

        Log.d(TAG, "onItemClick: Starts");
    }


}