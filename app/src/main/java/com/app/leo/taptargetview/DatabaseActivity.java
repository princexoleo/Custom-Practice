package com.app.leo.taptargetview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DatabaseActivity extends AppCompatActivity {
    ImageView imageView;
    TextView nametextView;
    String URL="https://api.github.com/users";
    User[] users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);



        init();

        StringRequest request=new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//success response
                Log.d("CODE",response);
                //create Json obj
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson=gsonBuilder.create();
               users = gson.fromJson(response,User[].class);
               setDetails(users);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DatabaseActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);
    }

    private void setDetails(User[] users) {
        Glide.with(DatabaseActivity.this)
                .load(users[0].getAvatarUrl())
                .into(imageView);
        nametextView.setText("Login : "+users[0].getLogin());

    }

    private void init() {
        imageView=findViewById(R.id.imageID);
        nametextView=findViewById(R.id.nameTextViewID);

    }
}
