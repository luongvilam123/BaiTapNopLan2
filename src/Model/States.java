package Model;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class States {
    String status;
    List<State> data;

    public List<State> getData() {
        return data;
    }
    public States(){

    }

    public void setData(List<State> data) {
        this.data = data;
    }

    public void getStatesData(String country){
        try{
            States states;
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
            List<State> stateList=states.getData();

            for(State state:stateList){
                System.out.println(state.getState());

            }

        }catch(IOException e){
            System.out.println(e);
        }
    }

    public class State{
        String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            state = state;
        }
    }
}
