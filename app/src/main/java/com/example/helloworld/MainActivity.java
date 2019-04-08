package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.CompButton);
        ((View) button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCompass();
            }
        });

        button2 = (Button) findViewById(R.id.AccButton);
        ((View) button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAcceleremoter();
            }
        });

    }

    public void openCompass() {
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }

    public void openAcceleremoter() {
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }


}
