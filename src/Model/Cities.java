package Model;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class Cities {
    String status;
    List<City> data;

    public List<City> getData() {
        return data;
    }
    public Cities() {

    }
    public void getCitiesData(String state,String country){

        try{
            Cities cities=null;
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://api.airvisual.com/v2/cities?state=" +
                            state+"&country=" +
                            country+"&key=d322b017-a519-458c-988c-2c01c3d034e1")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            Gson getData=new Gson();
            cities=getData.fromJson(response.body().string(),Cities.class);
            List<City> cityList=cities.getData();
            for(City city: cityList){
                System.out.println(city.getCity());
            }

        }catch(IOException e){
              System.out.print(e);
        }
    }


    public class City{
        String city;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
