package com.example.piechart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView pieChartImageView;
    private PieChartGenerator pieChartGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChartImageView = findViewById(R.id.pieChart);

        // Create an instance of PieChartGenerator and pass the ImageView
        pieChartGenerator = new PieChartGenerator(this, pieChartImageView);

    }
}