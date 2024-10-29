package com.example.lab4

import android.graphics.Color
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var gestureDetector: GestureDetector
    private lateinit var backgroundLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo LinearLayout
        backgroundLayout = findViewById(R.id.backgroundLayout)

        // Khởi tạo GestureDetector với các cử chỉ chạm và vuốt
        gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                backgroundLayout.setBackgroundColor(Color.BLUE)
                return true
            }

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                if (e1 != null) {
                    if (e1.y < e2.y) {
                        // Vuốt xuống
                        backgroundLayout.setBackgroundColor(Color.RED)
                    } else if (e1.y > e2.y) {
                        // Vuốt lên
                        backgroundLayout.setBackgroundColor(Color.YELLOW)
                    }
                }
                return true
            }
        })
    }

    // Xử lý sự kiện chạm
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
    }
}
