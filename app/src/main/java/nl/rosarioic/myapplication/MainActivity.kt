package nl.rosarioic.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grid.layoutManager = GridLayoutManager(this, 3);
        grid.adapter = Adapter()

//
//        val board = Board(this, 4,4);
//        board.orientation = LinearLayout.VERTICAL
//
//        test.addView(board)

//        test.addView(Line(this, 30, 10, Line.ORIENTATION_VERTICAL))
//        test.addView(Line(this, 30, 10, Line.ORIENTATION_VERTICAL))
//        test.addView(Line(this, 30, 10, Line.ORIENTATION_VERTICAL))
//        test.addView(Line(this, 30, 10, Line.ORIENTATION_VERTICAL))
//        test.addView(Line(this, 30, 10, Line.ORIENTATION_VERTICAL))
//        test.addView(Line(this, 30, 10, Line.ORIENTATION_VERTICAL))
//        test.addView(Line(this, 30, 10, Line.ORIENTATION_VERTICAL))
//        test.addView(Line(this, 30, 10, Line.ORIENTATION_VERTICAL))
//
//        test2.addView(Line(this, 30, 10, Line.ORIENTATION_HORIZONTAL))
//        test2.addView(Line(this, 30, 10, Line.ORIENTATION_HORIZONTAL))
//        test2.addView(Line(this, 30, 10, Line.ORIENTATION_HORIZONTAL))
//        test2.addView(Line(this, 30, 10, Line.ORIENTATION_HORIZONTAL))
//        test2.addView(Line(this, 30, 10, Line.ORIENTATION_HORIZONTAL))
//        test2.addView(Line(this, 30, 10, Line.ORIENTATION_HORIZONTAL))
//        test2.addView(Line(this, 30, 10, Line.ORIENTATION_HORIZONTAL))
    }
}
