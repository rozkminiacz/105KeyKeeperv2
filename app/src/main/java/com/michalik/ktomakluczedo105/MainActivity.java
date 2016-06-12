package com.michalik.ktomakluczedo105;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName;
    ListView listView;
    List<UsersKeys> usersKeysList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = (EditText)findViewById(R.id.editText);
        listView = (ListView)findViewById(R.id.listView);
        usersKeysList = new ArrayList<UsersKeys>();


    }
    public void takeOverKey(View view){
        String username = editTextUserName.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://rozkmin.esy.es/iHaveKeys.php?keykeeper="+username;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);

    }

    public void populateListView(View view) {
        String url = "http://rozkmin.esy.es/whoHasKeys.php?last=15";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CustomJSONParser customJSONParser = new CustomJSONParser(response);
                customJSONParser.parseObject();
                usersKeysList = customJSONParser.getUsersKeysList();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);

        List<String> list = new ArrayList<>();
        for (UsersKeys usersKeys : usersKeysList){
            list.add(usersKeys.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listelement, list);
        listView.setAdapter(adapter);
    }
}
