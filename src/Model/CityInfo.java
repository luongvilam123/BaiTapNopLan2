package Model;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class CityInfo {
    String status;
    data data;
    public CityInfo(){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Model.data getData() {
        return data;
    }

    public void setData(Model.data data) {
        this.data = data;
    }

    public void GetCityAqiUS(String city, String state, String country){
        try{
            CityInfo cityInfo=null;
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
        String kq=pollution.getAqius();
        System.out.println(kq);



    }catch(IOException e){
            System.out.println(e);
        }
    }
}
