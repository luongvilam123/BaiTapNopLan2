package UdpClientServer;

import Model.*;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class TestAPI {
    public static String getCountryData() {
        Countries countries = null;
        String result = "";
        try {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://api.airvisual.com/v2/countries?key=d322b017-a519-458c-988c-2c01c3d034e1")
                    .method("GET", null)
                    .build();
            Response response = null;
            response = client.newCall(request).execute();
            String jsonString = response.body().string();
            Gson gson = new Gson();
            countries = gson.fromJson(jsonString, Countries.class);
            result += "\nAll Country: \n";
            List<Countries.Country> listcountry = countries.getData();
            for (Countries.Country country : listcountry) {
                //System.out.println("Country: " + country.getCountry());
                result += "Name: " + country.getCountry() + " \n";
            }
            System.out.println( result);
        } catch (IOException e) {
            return result="";
        }
        return result;
    }

    public static String getStatesData(String country){
        String kq="";
        States states;
        try{

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://api.airvisual.com/v2/states?country=" +
                            country+"&key=d322b017-a519-458c-988c-2c01c3d034e1")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            String Json=response.body().string();
            Gson getData=new Gson();
            states=getData.fromJson(Json,States.class);
            kq += "\nAll States: \n";
            List<States.State> stateList=states.getData();

            for(States.State state:stateList){
               // System.out.println(state.getState());
                kq += "Name: " + state.getState() + " \n";
            }
            System.out.println( kq);

        }catch(IOException e){
            return kq="";
        }
        return kq;
    }
    public static String getCitiesData(String country,String state){
        String kq="";
        Cities cities=null;
        try{

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
            kq += "\nAll Cities: \n";
            List<Cities.City> cityList=cities.getData();
            for(Cities.City city: cityList){
               // System.out.println(city.getCity());
                kq += "Name: " + city.getCity() + " \n";
            }
            System.out.println( kq);

        }catch(IOException e){
            return kq="";
        }
        return kq;
    }
    public static String getAqiUsCity(String country, String state, String city){
        String kq="";
        CityInfo cityInfo=null;
        try{

            //http://api.airvisual.com/v2/city?city=Ho%20Chi%20Minh%20city&state=Ho%20Chi%20Minh%20city&country=Vietnam&key=d322b017-a519-458c-988c-2c01c3d034e1
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://api.airvisual.com/v2/city?city=" +
                            city+"&state=" +
                            state+"&country=" +
                            country+"&key=d322b017-a519-458c-988c-2c01c3d034e1")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            String Json=response.body().string();
            Gson getData=new Gson();
            cityInfo=getData.fromJson(Json,CityInfo.class);
            data data=new data();
            data=cityInfo.getData();
            current current=new current();
            current=data.getCurrent();
            pollution pollution=new pollution();
            pollution=current.getPollution();
            kq=pollution.getAqius();
            System.out.println(kq);

        }catch(IOException e){
            return kq="";
        }
        return "Chỉ số AqiUs: "+kq;
    }
    public static void main(String [] args) {
        //String country=getCountryData();
       // String state=getStatesData("Vietnam");
        //String cities=getCitiesData("Vietnam","Ho Chi Minh city");
        String kq=getAqiUsCity("Ho Chi Minh city","Ho Chi Minh city","Vietnam");
            }
}
