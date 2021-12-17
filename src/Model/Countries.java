package Model;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class Countries {
    String status;
    List<Country> data;
    public Countries(){

    }

    public List<Country> getData() {
        return data;
    }
    public void getCountriesData()  {
        try {
        Countries countries=null;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://api.airvisual.com/v2/countries?key=d322b017-a519-458c-988c-2c01c3d034e1")
                .method("GET", null)
                .build();
        Response response = null;
            response = client.newCall(request).execute();
            String jsonString =response.body().string();
            Gson gson=new Gson();
            countries=gson.fromJson(jsonString,Countries.class);
            List<Country>listcountry=countries.getData();
            for(Country country:listcountry){
                System.out.println(country.getCountry());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }





    }


    public class Country {
        String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
