package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name, Password;
    private TextView Info;
    private Button login;
    private int counter=5;
    private ImageView google,facebook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText) findViewById(R.id.name);
        Password=(EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.button);
        Info=(TextView) findViewById(R.id.tvinfo);
        Info.setText("No Of attemps remaining: 5");
        google=(ImageView)findViewById(R.id.google);
        facebook=(ImageView)findViewById(R.id.facebook);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator(Name.getText().toString(), Password.getText().toString());
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "http://www.facebook.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }

    private void validator(String userName, String userPassword){
        if( (userName.equals("Admin")) && (userPassword.equals("1234")) ){
            Intent intent = new Intent(MainActivity.this, ConverterActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("No of attemps remaining:"+ String.valueOf(counter));

            if(counter==0){
                login.setEnabled(false);
            }
        }
    }
}