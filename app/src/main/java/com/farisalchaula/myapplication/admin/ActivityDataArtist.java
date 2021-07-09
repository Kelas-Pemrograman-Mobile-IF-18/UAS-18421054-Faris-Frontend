package com.farisalchaula.myapplication.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.farisalchaula.myapplication.R;
import com.farisalchaula.myapplication.adapter.AdapterArtist;
import com.farisalchaula.myapplication.model.ModelArtist;
import com.farisalchaula.myapplication.server.BaseURL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityDataArtist extends AppCompatActivity {

    ProgressDialog pDialog;

    AdapterArtist adapter;
    ListView list;

    ArrayList<ModelArtist> newsList = new ArrayList<ModelArtist>();
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_artist);

        getSupportActionBar().setTitle("Data Artist");
        mRequestQueue = Volley.newRequestQueue(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        list = (ListView) findViewById(R.id.array_list);
        newsList.clear();
        adapter = new AdapterArtist(ActivityDataArtist.this, newsList);
        list.setAdapter(adapter);
        getAllBuku();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ActivityDataArtist.this, HomeAdminActivity.class);
        startActivity(i);
        finish();
    }

    private void getAllBuku() {
        // Pass second argument as "null" for GET requests
        pDialog.setMessage("Loading");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, BaseURL.dataArtist, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            boolean status = response.getBoolean("error");
                            if (status == false) {
                                Log.d("data artist = ", response.toString());
                                String data = response.getString("data");
                                JSONArray jsonArray = new JSONArray(data);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    final ModelArtist artist = new ModelArtist();
                                    final String _id = jsonObject.getString("_id");
                                    final String artistName = jsonObject.getString("artistName");
                                    final String artistCode = jsonObject.getString("artistCode");
                                    final String workDays = jsonObject.getString("workDays");
                                    final String workProgress = jsonObject.getString("workProgress");
                                    final String email = jsonObject.getString("email");
                                    final String commissionSheet = jsonObject.getString("commissionSheet");
                                    artist.setArtistCode(artistCode);
                                    artist.setArtistName(artistName);
                                    artist.setWorkDays(workDays);
                                    artist.setWorkProgress(workProgress);
                                    artist.setEmail(email);
                                    artist.setCommissionSheet(commissionSheet);
                                    artist.set_id(_id);

                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            System.out.println("Clicked");
                                            // TODO Auto-generated method stub
                                            Intent a = new Intent(ActivityDataArtist.this, EditArtistAndDeleteActivity.class);
                                            a.putExtra("artistCode", newsList.get(position).getArtistCode());
                                            a.putExtra("_id", newsList.get(position).get_id());
                                            a.putExtra("artistName", newsList.get(position).getArtistName());
                                            a.putExtra("workDays", newsList.get(position).getWorkDays());
                                            a.putExtra("workProgress", newsList.get(position).getWorkProgress());
                                            a.putExtra("email", newsList.get(position).getEmail());
                                            a.putExtra("commissionSheet", newsList.get(position).getCommissionSheet());
                                            startActivity(a);
                                        }
                                    });
                                    newsList.add(artist);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                hideDialog();
            }
        });

        /* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
