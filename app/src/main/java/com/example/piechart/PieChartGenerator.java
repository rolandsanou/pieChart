package com.example.piechart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PieChartGenerator {
    private Context context;
    private ImageView pieChartView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    private RectF[] segments;
    private int[] categoryTimes;
    private String[] categories;
    private int totalMinutes;

    public PieChartGenerator(Context context, ImageView pieChartView) {
        this.context = context;
        this.pieChartView = pieChartView;

        // Define data for 10 categories (replace with your actual data)
        categories = new String[]{
                "Category 1", "Category 2", "Category 3", "Category 4", "Category 5",
                "Category 6", "Category 7", "Category 8", "Category 9", "Category 10"
        };

        // Define time spent in minutes for each category in a 24-hour day (replace with actual data)
        categoryTimes = new int[]{180, 240, 120, 90, 60, 210, 180, 270, 150, 300}; // Minutes

        totalMinutes = 1440; // Total minutes in a day (24 hours)

        // Create a bitmap and a canvas to draw the ring chart
        bitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);

        // Set up the paint for drawing
        paint = new Paint();
        paint.setAntiAlias(true);

        // Initialize the pie chart and segments
        initializePieChart();


    }

    private void initializePieChart() {
        float startAngle = 0;
        float strokeWidth = 10; // Adjust this value to control the thickness of the ring

        segments = new RectF[categories.length];

        for (int i = 0; i < categories.length; i++) {
            float sweepAngle = (float) categoryTimes[i] / totalMinutes * 360;

            paint.setColor(Color.HSVToColor(new float[]{(360.0f / categories.length) * i, 1, 1}));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(strokeWidth);

            // Define the rectangular bounds of the ring
            RectF rectF = new RectF(strokeWidth, strokeWidth, 300 - strokeWidth, 300 - strokeWidth);

            // Draw the ring segment
            canvas.drawArc(rectF, startAngle, sweepAngle, false, paint);

            // Store the segment bounds for click detection
            segments[i] = new RectF(rectF);

            startAngle += sweepAngle;
        }

        // Display the pie chart in the ImageView
        pieChartView.setImageBitmap(bitmap);
    }
}
