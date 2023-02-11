package com.lab_aswinisasikanth_c0880827_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FavouriteLocations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_locations);
        ListView listView=findViewById(R.id.locationList);


        List<String> retrievedList = getList();
        Toast.makeText(this, retrievedList.toString(), Toast.LENGTH_SHORT).show();



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                retrievedList );

        listView.setAdapter(arrayAdapter);



    }
    public List<String> getList() {
        String savedString = PreferenceManager.getDefaultSharedPreferences(FavouriteLocations.this).getString("My_SAVED_LIST", "");
        List<String> list = new ArrayList<>();
        if (!savedString.isEmpty()) {
            list = Arrays.asList(savedString.split("__,__"));
        }
        return list;
    }
}