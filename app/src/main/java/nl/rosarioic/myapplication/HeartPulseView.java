package nl.rosarioic.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;


class HeartPulseView extends View {

    Path path = new Path();
    Paint paint = new Paint();
    float test, test1;

    public HeartPulseView(Context context) {
        super(context);
        init();

    }

    public HeartPulseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeartPulseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public HeartPulseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        path.lineTo(test, test1);

        canvas.drawPath(path, paint);
    }

    private void init(){
        path.moveTo(100, 100);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);


        ValueAnimator valueAnimator = ValueAnimator.ofFloat(100, 900);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                test1 = (float) animation.getAnimatedValue() + 100;
                test++;
                invalidate();
                Log.d("TAG", "onAnimationUpdate: " + test1);
            }
        });

        valueAnimator.start();
    }
}