package com.ingrammicro.inrans00.imonline;

/**
 * Created by INRANS00 on 9/11/2018.
 */

class Country {

    private int mImageResourceId;
    private String mCountryName;

    public Country(int imageResourceId, String countryName){

        mImageResourceId = imageResourceId;
        mCountryName = countryName;
    }

    public String getmCountryName() {
        return mCountryName;
    }

    public void setmCountryName(String mCountryName) {
        this.mCountryName = mCountryName;
    }

    public int getmImageResourceId() {
        return mImageResourceId;

    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
}
