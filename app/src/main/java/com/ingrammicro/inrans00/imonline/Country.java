package com.ingrammicro.inrans00.imonline;

/**
 * Created by INRANS00 on 9/11/2018.
 */

class Country{
    private String mCountryName;
    private String mCountryCode;
    private int ImageResourceId;


    public Country(){

    }
    public Country(String countryName, String countryCode){
         mCountryCode = countryCode;
         mCountryName = countryName;

    }

    public String getmCountryName() {
        return mCountryName;
    }

    public void setmCountryName(String mCountryName) {
        this.mCountryName = mCountryName;
    }

    public String getmCountryCode() {
        return mCountryCode;
    }

    public void setmCountryCode(String mCountryCode) {
        this.mCountryCode = mCountryCode;
    }

    public int getImageResourceId() {

        return ImageResourceId;
    }

    public void setImageResourceId(int mImageResourceId) {
        this.ImageResourceId = mImageResourceId;
    }



}