package nl.rosarioic.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout

class Board: LinearLayout {
    constructor(context: Context, column: Int, row: Int): super(context){
        for(i in 1..row*2+1){
            val linearLayout = LinearLayout(context)
            for(j in 1..column+1){
                if(i % 2 == 1) linearLayout.addView(Line(context, 100, 10, Line.ORIENTATION_HORIZONTAL))
                else if(i % 2 == 0) linearLayout.addView(Line(context, 100, 10, Line.ORIENTATION_VERTICAL))
                else if(i % 2 == 1 && j == column+1) linearLayout.addView(Line(context, 100, 10, Line.ORIENTATION_VERTICAL))
            }
            addView(linearLayout)
        }
    }

}