package Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Util.Utils;

/**
 * Created by Rifat on 9/10/2018.
 */


//This is the place where we are going to parse JSON data from server
public class WeatherClientHttp {


    // Create our http connection between our app and api
    public String getWeatherData(String place) {

        HttpURLConnection connection = null;

        //Everything is gonna get from the web is as an InputStram
        InputStream inputStream;

        try {
            //Make the connection with web
            connection = (HttpURLConnection) (new URL(Utils.BASE_URL + place)).openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            //TODO:Read the response from  URL

            //Put all of our data getting from web
            StringBuffer stringBuffer=new StringBuffer();
            inputStream=connection.getInputStream();

            // This can read all the inputStream getting from the Web
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line=null;

            //Start reading all data line by line and put everything on stringBuffer
            while (true){
                stringBuffer.append(line +"\r\n");
            }
            inputStream.close();
            connection.disconnect();

            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();

        }

        return null;
    }

}
