package com.example.dadabhagwan.rectrofijsonpostandget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThirdActivity extends Activity {

    String url = "https://jsonplaceholder.typicode.com";

    EditText edt_title, edt_body, edt_userId;
    Button btn_addPost;
    TextView tv_addPostResult;
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        edt_title = (EditText) findViewById(R.id.edt_title);
        edt_body = (EditText) findViewById(R.id.edt_body);
        edt_userId = (EditText) findViewById(R.id.edt_userId);
        btn_addPost = (Button) findViewById(R.id.btn_addPost);
        tv_addPostResult = (TextView) findViewById(R.id.tv_addPostResult);
        btn_addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAddPostAPI(url);
            }
        });



    }
    private void callAddPostAPI(String url) {
        if (isNetworkAvailable()) {

            mProgressDialog = new ProgressDialog(ThirdActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Android JSON Parse Tutorial");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonObjectAPI service = retrofit.create(JsonObjectAPI.class);

            AddPostRequest addPostRequest = new AddPostRequest(edt_title.getText().toString().trim(),
                    edt_body.getText().toString().trim(),
                    Long.parseLong(edt_userId.getText().toString().trim()));

            Call<AddPostResponse> call = service.addPost(addPostRequest);

            call.enqueue(new Callback<AddPostResponse>() {
                @Override
                public void onResponse(Call<AddPostResponse> call, Response<AddPostResponse> response) {
                    mProgressDialog.dismiss();
                    if (response != null && response.body() != null) {
                        AddPostResponse addPostResponse = response.body();

                        tv_addPostResult.setText("Result ---> \nTitle - " + addPostResponse.getTitle() +
                                "\nBody - " + addPostResponse.getBody() +
                                "\nPost Id - " + addPostResponse.getId());
                    }
                }

                @Override
                public void onFailure(Call<AddPostResponse> call, Throwable t) {
                    mProgressDialog.dismiss();
                }
            });
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
