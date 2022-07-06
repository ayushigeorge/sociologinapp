package com.example.sociologinapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    ImageView g_logo, f_logo, t_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username= (TextView) findViewById(R.id.username);
        TextView password= (TextView) findViewById(R.id.password);
        g_logo= findViewById(R.id.glogo);
        f_logo= findViewById(R.id.flogo);
        t_logo= findViewById(R.id.tlogo);

        MaterialButton loginbtn= (MaterialButton) findViewById(R.id.signinbutton);

        loginbtn.setOnClickListener((View v) -> {
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                Toast.makeText(MainActivity.this,"Login Ok", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();

        });
        g_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAppLink= "fb://page/237564710351658";
                String sPackage= "com.facebook.katana";
                String sWebLink ="https://www.facebook.com/theengineergeorge/";
                openLink(sAppLink, sPackage, sWebLink);
            }
        });
        f_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAppLink= "https://www.instagram.com/theengineergeorge";
                String sPackage= "com.instagram.theengineergeorge";
                String sWebLink= "https://www.instagram.com/theengineergeorge/?utm_medium=copy_link";
                openLink(sAppLink,sPackage,sWebLink);
            }
        });
        t_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sApplink ="twitter://user?screen_name=ayushigeorge31";
                String sPackage="com.twitter.ayushigeorge31";
                String sWebLink= "https://twitter.com/ayushigeorge31";
                openLink(sApplink, sPackage, sWebLink);
            }
        });
    }

    private void openLink(String sAppLink, String sPackage, String sWebLink) {
        try{
            Uri uri =Uri.parse(sAppLink);
            Intent intent= new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(sPackage);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException activityNotFoundException){
            Uri uri= Uri.parse(sWebLink);
            Intent intent= new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


    }
}