package com.ingrammicro.inrans00.imonline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by INRANS00 on 9/14/2018.
 */

class HttpHandler {
    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler() {
    }

    public static String makeServiceCall(String reqUrl) {
        String jsonResponse = "";
        if (reqUrl == null) {

        }


        HttpURLConnection connection = null;
        StringBuffer response = null;
        try {
            URL url;
            url = new URL(reqUrl);
            response = new StringBuffer();
            connection = (HttpURLConnection) url.openConnection();
//            conn.setDoOutput(false);
//            conn.setDoInput(true);
//            conn.setUseCaches(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/mobile;charset=UTF-8");

            // handle the response
            int status = connection.getResponseCode();
            if (status != 200) {
                throw new IOException("success " + status);
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine + "\n");
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }

            //Here is your json in string format
            jsonResponse = response.toString();
        }


        return jsonResponse;
    }
}


