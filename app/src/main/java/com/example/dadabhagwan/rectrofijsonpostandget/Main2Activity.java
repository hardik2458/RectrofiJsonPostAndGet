package com.example.dadabhagwan.rectrofijsonpostandget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {

    Button btnGet,btnPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnGet= (Button) findViewById(R.id.btn_get);
        btnPost= (Button) findViewById(R.id.btn_post);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i2);

            }
        });
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i22=new Intent(Main2Activity.this,ThirdActivity.class);
                startActivity(i22);

            }
        });

    }
}
