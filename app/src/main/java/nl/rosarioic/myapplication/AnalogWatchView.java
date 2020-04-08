package nl.rosarioic.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

public class AnalogWatchView extends View {
    int hour = 0;
    int min = 0;
    int sec;

    int midX;
    int midY;


    float radius = 400;

    Path path;
    Paint hourPaint;
    Paint minPaint;
    Paint secPaint;

    Paint textPaint;

    Paint mainCirclePaint;

    public AnalogWatchView(Context context) {
        super(context);
        init();
    }

    public AnalogWatchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnalogWatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AnalogWatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        path = new Path();

        hourPaint = new Paint();
        hourPaint.setAntiAlias(true);
        hourPaint.setStyle(Paint.Style.STROKE);
        hourPaint.setStrokeWidth(25);
        hourPaint.setColor(Color.BLACK);

        minPaint = new Paint(hourPaint);
        minPaint.setStrokeWidth(15);
        minPaint.setColor(Color.BLUE);


        secPaint = new Paint(hourPaint);
        secPaint.setStrokeWidth(8);
        secPaint.setColor(Color.RED);


        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(60);

        mainCirclePaint = new Paint(hourPaint);
        mainCirclePaint.setStrokeWidth(8);
        mainCirclePaint.setColor(Color.RED);

        new CountDownTimer(24 * 60 * 60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sec += 1;
                if (sec >= 60) {
                    sec = 0;
                    min += 1;
                }
                if (min >= 60) {
                    hour += 1;
                    min = 0;
                }

                if (hour >= 12) {
                    hour = 0;
                }
                postInvalidate();
            }

            @Override
            public void onFinish() {

            }
        }.start();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        midX = getWidth() / 2;
        midY = getHeight() / 2;

        drawTimeText(canvas);

        canvas.drawCircle(midX, midY, radius, mainCirclePaint);

        drawHands(canvas);

    }

    private void drawTimeText(Canvas canvas) {
        for (int i = 1; i <= 12; i++) {
            float angle = (float) Math.toRadians((0.5 * 60 * i) - 90);
            float textPaintCentre = (textPaint.descent() + textPaint.ascent()) / 2;
            canvas.drawText(
                    "" + i,
                    (radius - 50) * (float) Math.cos(angle) + midX + textPaintCentre,
                    (radius - 50) * (float) Math.sin(angle) + midY - textPaintCentre,
                    textPaint
            );

        }
    }

    private void drawHands(Canvas canvas) {
        path.rewind();
        path.moveTo(midX, midY);
        float hourAngle = (float) Math.toRadians(0.5 * ((60 * hour) + min) - 90);
        path.lineTo(((radius - 200) * (float) Math.cos(hourAngle)) + midX, ((radius - 200) * (float) Math.sin(hourAngle)) + midY);

        canvas.drawPath(path, hourPaint);

        path.rewind();
        path.moveTo(midX, midY);

        float minAngle = (float) Math.toRadians(6 * min - 90);
        path.lineTo(((radius - 150) * (float) Math.cos(minAngle)) + midX, ((radius - 150) * (float) Math.sin(minAngle)) + midY);

        canvas.drawPath(path, minPaint);


        path.rewind();
        path.moveTo(midX, midY);

        float secAngle = (float) Math.toRadians(6 * sec - 90);
        path.lineTo(((radius - 100) * (float) Math.cos(secAngle)) + midX, ((radius - 100) * (float) Math.sin(secAngle)) + midY);

        canvas.drawPath(path, secPaint);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
}
