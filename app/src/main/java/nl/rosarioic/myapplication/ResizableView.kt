package nl.rosarioic.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

class ResizableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyle, defStyleRes) {

    var mWidth: Int = 200
    var mHeight: Int = 200

    var mPaint: Paint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 20F
        color = Color.RED
    }


    init {

    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRect(100F, 100F, 100F + mWidth, 100F + mHeight, mPaint)
    }

    var startX: Float = 0F
    var startY: Float = 0F

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                mPaint.color = Color.GREEN
                startX = event.x
                startY = event.y
            }
            MotionEvent.ACTION_UP -> {
                mPaint.color = Color.RED
            }

            MotionEvent.ACTION_MOVE -> {
                if (startX < event.x)
                    mWidth += abs(startX - event.x).toInt()
                else mWidth -= abs(startX - event.x).toInt()

                if (startY < event.y)
                    mHeight += abs(startY - event.y).toInt()
                else mHeight -= abs(startY - event.y).toInt()

                startX = event.x
                startY = event.y
            }
        }

        Log.d("test", " test $event")

        postInvalidate()
        return true
    }

}