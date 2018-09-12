package com.ingrammicro.inrans00.imonline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INRANS00 on 9/11/2018.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder>{
    private Context mContext;
    ArrayList<Country> mCountry;


   public CountryAdapter(Context mContext,ArrayList<Country> mCountry){
       this.mCountry = mCountry;
       this.mContext = mContext;


   }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view ;
       LayoutInflater mInflater = LayoutInflater.from(mContext);
       view = mInflater.inflate(R.layout.content_country,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       holder.countryName.setText(mCountry.get(position).getmCountryName());
       holder.countryFlag.setImageResource(mCountry.get(position).getmImageResourceId());

    }



    @Override
    public int getItemCount() {
        return mCountry.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

       TextView countryName;
       ImageView countryFlag;


        public MyViewHolder(View itemView) {
            super(itemView);

            countryName = (TextView) itemView.findViewById(R.id.name);
            countryFlag = (ImageView) itemView.findViewById(R.id.flag);
        }
    }
}
