package nl.rosarioic.myapplication

import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.KeyEvent.ACTION_DOWN
import android.view.MotionEvent
import android.view.View

class Line : View {

    companion object {
        const val ORIENTATION_VERTICAL = 0
        const val ORIENTATION_HORIZONTAL = 1
    }
    private var orientation: Int = ORIENTATION_HORIZONTAL
    set(value) {
        field = value
        invalidate()
    }

    private var length: Int = 300
    set(value) {
        field = value
        invalidate()
    }
    private var thikness: Int = 30
    set(value) {
        field = value
        invalidate()
    }

    private var color: Int = Color.RED
    set(value) {
        field = value
        invalidate()
    }


    constructor(context: Context, length: Int, thikness: Int, orientation: Int) : super(context){
        this.length = length
        this.thikness = thikness
        this.orientation = orientation
    }

    constructor(context: Context, attrs: AttributeSet):super(context, attrs){
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Line,
            0, 0).apply {

            try {
                orientation = getInt(R.styleable.Line_orientation, ORIENTATION_HORIZONTAL)
            } finally {
                recycle()
            }
        }
    }

    private val paint = Paint().apply {
        isAntiAlias = true
        color = Color.RED
        style = Paint.Style.FILL
    }
    private val rect = Rect()



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = color;

        canvas?.apply {
            rect.set(
                0,
                0,
                if(orientation == ORIENTATION_VERTICAL)  thikness else length,
                if(orientation == ORIENTATION_VERTICAL)  length else thikness
            )
            drawRect(rect, paint)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if(orientation == ORIENTATION_VERTICAL) setMeasuredDimension(length , length)
        else if(orientation == ORIENTATION_HORIZONTAL) setMeasuredDimension(length , thikness)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                color = Color.GREEN
                invalidate()
            }
        }

        return true
    }

}