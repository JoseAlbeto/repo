package com.example.albertoagenda.permisos;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button camara, audio;
    private final int REQUEST_ACCESS=0;
    private final int REQUEST_ACCESS2=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camara = (Button)findViewById(R.id.camara);
        audio = (Button) findViewById(R.id.audio);

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, REQUEST_ACCESS2);
                }else{

                }

            }
        });

        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.RECORD_AUDIO}, REQUEST_ACCESS);
                }else{

                }
            }
        });


    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String [] permissions, @NonNull int [] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions , grantResults);
        if(requestCode==REQUEST_ACCESS2){
            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camaraIntent);
            }else{
                Toast.makeText(this,"Permisos denegado",Toast.LENGTH_SHORT).show();
            }
      if(requestCode==REQUEST_ACCESS){
            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Intent audioIntent = new Intent(String.valueOf(MediaRecorder.AudioEncoder.AMR_NB));
                    startActivity(audioIntent);
            }else{
                    Toast.makeText(this,"Permisos denegado",Toast.LENGTH_SHORT).show();
                }

    }



    }

}
