package com.example.dadabhagwan.rectrofijsonpostandget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends Activity {

    RecyclerView recycleView;
    RecycleAdapterView2 adapter;
    LinearLayoutManager linearLayoutManager;
    ProgressDialog PD;
    Long userId;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recycleView= (RecyclerView) findViewById(R.id.recycleView1);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycleView.setLayoutManager(linearLayoutManager);
        userId=getIntent().getLongExtra("key",0);

        PD=new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);
        PD.setTitle("Please Wait..");
        PD.show();
        apiClient(BASE_URL);
    }
    public void apiClient(String BASE_URL)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonObjectAPI service = retrofit.create(JsonObjectAPI.class);
        Call<List<User>> call=service.getSelectedUserData(userId);
        call.enqueue(new Callback<List<User>>() {
                         @Override
                         public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                             PD.dismiss();
                             List<User> data=response.body();
                             adapter=new RecycleAdapterView2(SecondActivity.this,data);
                             recycleView.setAdapter(adapter);

                         }

                         @Override
                         public void onFailure(Call<List<User>> call, Throwable t) {
                          PD.dismiss();
                         }
                     }
        );


    }
}
