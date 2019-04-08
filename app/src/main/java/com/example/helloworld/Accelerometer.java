package com.example.helloworld;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Accelerometer extends Activity implements SensorEventListener {



    private SensorManager sensorManager;
    private Sensor sensor;

    private TextView xText;
    private TextView yText;
    private TextView zText;

    private ConstraintLayout li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);


        //create our Sensor Manager

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Acc sensor

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Assign TextView

        xText = findViewById (R.id.xText);
        yText = findViewById (R.id.yText);
        zText = findViewById (R.id.zText);

        li = findViewById(R.id.myAcc);
    }


    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        li.setBackgroundColor(Color.rgb(
                Math.round(event.values[0] / event.values[2]) * 10,
                Math.round(event.values[1] / event.values[0]) * 10,
                Math.round(event.values[2] / event.values [1]) * 10));
    }
}