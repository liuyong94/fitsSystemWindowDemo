package com.example.fitssystemwindowsdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.view.ViewCompat

class ActivityFrameLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)
        window.statusBarColor = Color.TRANSPARENT
        val frameLayout = findViewById<FrameLayout>(R.id.root_layout)
        frameLayout.systemUiVisibility = (SYSTEM_UI_FLAG_LAYOUT_STABLE
                or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

        val button = findViewById<Button>(R.id.button)
        ViewCompat.setOnApplyWindowInsetsListener(button) { view, insets ->
            val params = view.layoutParams as FrameLayout.LayoutParams
            params.topMargin = insets.systemWindowInsetTop
            insets
        }
    }
}