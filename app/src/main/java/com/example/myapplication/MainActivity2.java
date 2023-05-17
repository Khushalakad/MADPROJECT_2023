package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
     MediaPlayer mp=MediaPlayer.create(MainActivity2.this, R.raw.stranger);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MediaPlayer mp=MediaPlayer.create(MainActivity2.this, R.raw.stranger);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
                mp.start();
            }
        });


    }
    public void openMainActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
