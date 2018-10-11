package com.ingrammicro.inrans00.imonline;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;


import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String TAG = CountryActivity.class.getSimpleName();
    private String countryName;




    private ProgressDialog pDialog;
    RecyclerView recyclerView;


    // URL to get contacts JSON
    private static String jsonurl = "https://mobility-stg.ingrammicro.com/Dispatcher/Countrylist/?sid=&country=AU&LANGCODE=en&CONNECTIONTYPE=WIFI&lang=en&AGENT=Android&APPVERSION=3.0&DEVICE=mido&OSVERSION=3.18.31-perf-g5d1394b8 ";

    ArrayList<Country> mCountry;
    ArrayList<Integer> imid;
    private Context ctx;
    private CountryAdapter customAdapter;
    private int setmImageResourceId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);


       ;



        ctx = this;
         recyclerView = (RecyclerView) findViewById(R.id.recyview);
         //set a LinearLayoutManager with default vertical orientation
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ctx);

        recyclerView.setLayoutManager(layoutManager);

        SearchView searchView = (SearchView) findViewById(R.id.simpleSearchView);
        CharSequence query = searchView.getQuery();
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Choose your country");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return false;
            }
        });



        //  call the constructor of CustomAdapter to send the reference and data to Adapter


        new countryAsyncTask().execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "" + countryName,
                Toast.LENGTH_SHORT).show();

    }

    /** @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    /**
     * Async task class to get json by making HTTP call
     */

    private class countryAsyncTask extends AsyncTask<Void, Void, ArrayList<Country>> {




        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(CountryActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }


        @Override
        protected ArrayList<Country> doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(jsonurl);
            Log.e(TAG, "Response from url: " + jsonStr);
            mCountry = new ArrayList<Country>();

            if (jsonStr != null && jsonStr.length() > 1) {
                String[] countriesData = jsonStr.split("\n");
                Log.e("country", "" + countriesData.toString());

                {
                    for (int i = 0; i < 20; i++) {
                        Log.d("CountryData", countriesData[i]);

                        //run for loop on single country data with delimiter ';'
                        String[] countryData = countriesData[i].split(";");

                        // String[] counryData1 = countryData[i].split(".");
                        String countryCode = "", countryName = "";
                        if (countryData.length >= 2) {
                            countryCode = countryData[0];
                            countryName = countryData[1];
                        }


                        Country country = new Country();
                        countryName = countryName.substring(1,countryName.length()-1);
                        country.setmCountryCode(countryCode);
                        country.setmCountryName(countryName);

                        {
                            if (TextUtils.equals(countryCode, "\"AU\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_australia);
                            } else if (TextUtils.equals(countryCode, "\"BE\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_belgium);
                            } else if (TextUtils.equals(countryCode, "\"BR\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_brazil);
                            } else if (TextUtils.equals(countryCode, "\"CA\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_canada);
                            } else if (TextUtils.equals(countryCode, "\"CL\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_chile);
                            }  else if (TextUtils.equals(countryCode, "\"CO\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_colombia);
                            }
                            else if (TextUtils.equals(countryCode, "\"FR\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_france);
                            }
                            else if (TextUtils.equals(countryCode, "\"DE\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_germany);
                            }
                            else if (TextUtils.equals(countryCode, "\"HK\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_hongkong);
                            }
                            else if (TextUtils.equals(countryCode, "\"IN\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_india);
                            }
                            else if (TextUtils.equals(countryCode, "\"ID\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_indonesia);
                            }
                            else if (TextUtils.equals(countryCode, "\"MY\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_malaysia);
                            }
                            else if (TextUtils.equals(countryCode, "\"MX\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_mexico);
                            }
                            else if (TextUtils.equals(countryCode, "\"MY\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_malaysia);
                            }
                            else if (TextUtils.equals(countryCode, "\"NL\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_netherlands);
                            }
                            else if (TextUtils.equals(countryCode, "\"NZ\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_newzealand);
                            }
                            else if (TextUtils.equals(countryCode, "\"PE\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_peru);
                            }
                            else if (TextUtils.equals(countryCode, "\"SG\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_singapore);
                            }
                            else if (TextUtils.equals(countryCode, "\"SE\"")) {
                                country.setImageResourceId(R.drawable.ic_flag_sweden);
                            }
                            else
                                country.setImageResourceId(R.drawable.ic_flag_usa);
                            }





                            //country.setImageResourceId(R.drawable.ic_flag_chile);

                        //switch (countryCode){
                        //case1: )countryCode = "AU" ;
                          //  country.setImageResourceId(R.drawable.ic_flag_australia);
//
 //                           }


                            mCountry.add(country);

                    }
                    

                }
                
                



            }
            return mCountry;
        }





        @Override
        protected void onPostExecute(ArrayList<Country> result) {
           // pDialog.dismiss();
            super.onPostExecute(result);

            // Locate the listview in listview_main.xml

            // Pass the results into ListViewAdapter.java
            customAdapter = new CountryAdapter(CountryActivity.this, mCountry);
            // Set the adapter to the ListView
            recyclerView.setAdapter(customAdapter);
            //recyclerView.setOnItemClickListener(this);

            // Close the progressdialog
           pDialog.dismiss();

        }
    }
}










