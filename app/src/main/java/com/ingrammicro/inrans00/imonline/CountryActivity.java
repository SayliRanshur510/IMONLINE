package com.ingrammicro.inrans00.imonline;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.zip.Inflater;

public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList mCountry = new ArrayList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyview);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter


        mCountry = new ArrayList<>();
        mCountry.add(new Country(R.drawable.ic_flag_australia, "Australia"));
        mCountry.add(new Country(R.drawable.ic_flag_belgium, "Belgium"));
        mCountry.add(new Country(R.drawable.ic_flag_brazil, "Brazil"));
        mCountry.add(new Country(R.drawable.ic_flag_canada, "Canada"));
        mCountry.add(new Country(R.drawable.ic_flag_chile, "Chile"));
        mCountry.add(new Country(R.drawable.ic_flag_colombia, "Columbia"));
        mCountry.add(new Country(R.drawable.ic_flag_france, "France"));
        mCountry.add(new Country(R.drawable.ic_flag_hongkong, "Hong Kong"));
        mCountry.add(new Country(R.drawable.ic_flag_india, "India"));
        mCountry.add(new Country(R.drawable.ic_flag_indonesia, "Indonesia"));
        mCountry.add(new Country(R.drawable.ic_flag_malaysia, "Malaysia"));
        mCountry.add(new Country(R.drawable.ic_flag_mexico, "Mexico"));
        mCountry.add(new Country(R.drawable.ic_flag_mexico, "Miami"));
        mCountry.add(new Country(R.drawable.ic_flag_netherlands, "Netherlands"));
        mCountry.add(new Country(R.drawable.ic_flag_newzealand, "New Zealand"));
        mCountry.add(new Country(R.drawable.ic_flag_peru, "Peru"));
        mCountry.add(new Country(R.drawable.ic_flag_singapore, "Singapore"));
        mCountry.add(new Country(R.drawable.ic_flag_sweden, "Sweden"));
        mCountry.add(new Country(R.drawable.ic_flag_usa, "United States America"));

        CountryAdapter customAdapter = new CountryAdapter(CountryActivity.this, mCountry);
        recyclerView.setAdapter(customAdapter);
    }
    public boolean onCreateMenuOption(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getBaseContext(), query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getBaseContext(), newText, Toast.LENGTH_LONG).show();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
}




