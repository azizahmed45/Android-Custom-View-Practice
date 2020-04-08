package nl.rosarioic.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

public class SolarSystemView extends View {

    int circle1;
    int circle2;
    int circle3;
    int circle4;
    private Paint paint;
    private Paint paint2;
    private Paint paint3;

    public SolarSystemView(Context context) {
        super(context);

    }

    public SolarSystemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SolarSystemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SolarSystemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);

        paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.FILL);

        paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(Color.rgb(252, 212, 64));
        paint3.setStyle(Paint.Style.FILL);

        canvas.drawCircle(500, 500, 70, paint3);

        canvas.drawCircle(500, 500, 100, paint);
        canvas.drawCircle(500, 500, 150, paint);
        canvas.drawCircle(500, 500, 250, paint);
        canvas.drawCircle(500, 500, 450, paint);

        canvas.drawCircle(
                100 * (float) Math.cos(Math.toRadians(circle1)) + 500,
                100 * (float) Math.sin(Math.toRadians(-circle1)) + 500,
                10,
                paint2
        );

        canvas.drawCircle(
                150 * (float) Math.cos(Math.toRadians(circle2)) + 500,
                150 * (float) Math.sin(Math.toRadians(-circle2)) + 500,
                20,
                paint2
        );

        canvas.drawCircle(
                250 * (float) Math.cos(Math.toRadians(circle3)) + 500,
                250 * (float) Math.sin(Math.toRadians(-circle3)) + 500,
                30,
                paint2
        );

        canvas.drawCircle(
                450 * (float) Math.cos(Math.toRadians(circle4)) + 500,
                450 * (float) Math.sin(Math.toRadians(-circle4)) + 500,
                40,
                paint2
        );

    }

    public void animateTest() {
        ValueAnimator widthAnimator = ValueAnimator.ofInt(0, 360);
        widthAnimator.setInterpolator(new LinearInterpolator());
        widthAnimator.setDuration(1000);
        widthAnimator.setRepeatCount(ValueAnimator.INFINITE);
        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                circle1 = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        widthAnimator.start();

        ValueAnimator widthAnimator2 = ValueAnimator.ofInt(0, 360);
        widthAnimator2.setInterpolator(new LinearInterpolator());
        widthAnimator2.setDuration(2000);
        widthAnimator2.setRepeatCount(ValueAnimator.INFINITE);
        widthAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                circle2 = (int) animation.getAnimatedValue();
            }
        });
        widthAnimator2.start();

        ValueAnimator widthAnimator3 = ValueAnimator.ofInt(0, 360);
        widthAnimator3.setInterpolator(new LinearInterpolator());
        widthAnimator3.setDuration(3000);
        widthAnimator3.setRepeatCount(ValueAnimator.INFINITE);
        widthAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                circle3 = (int) animation.getAnimatedValue();
            }
        });
        widthAnimator3.start();

        ValueAnimator widthAnimator4 = ValueAnimator.ofInt(0, 360);
        widthAnimator4.setInterpolator(new LinearInterpolator());
        widthAnimator4.setDuration(4000);
        widthAnimator4.setRepeatCount(ValueAnimator.INFINITE);
        widthAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                circle4 = (int) animation.getAnimatedValue();
            }
        });
        widthAnimator4.start();
    }
}
