package nl.rosarioic.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.annotation.DimenRes

class DrawingBoard(context: Context, attrs: AttributeSet): View(context, attrs) {

    private var pointerSize: Float
    private var axisX: Float = 0.0f
    private var axisY: Float = 0.0f

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Line,
            0, 0).apply {

            try {
                pointerSize = getDimension(R.styleable.DrawingBoard_pointerSize, 10F)
            } finally {
                recycle()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(width.toInt(), height.toInt())
    }

    private val paint = Paint().apply {
        isAntiAlias = true
        color = Color.RED
        style = Paint.Style.FILL
    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.apply {
            drawCircle(axisX, axisX, pointerSize, paint);
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        axisX = event?.getX(event?.getPointerId(0))!!
        axisY = event?.getY(event?.getPointerId(0))!!
        invalidate()
        return true
    }

}