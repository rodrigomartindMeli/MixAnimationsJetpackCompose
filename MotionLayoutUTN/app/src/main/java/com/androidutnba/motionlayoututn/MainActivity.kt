package com.androidutnba.motionlayoututn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.androidutnba.motionlayoututn.conjunctiondemo.FullDemoActivity
import com.androidutnba.motionlayoututn.customattribute.CustomAttributeDemoActivity
import com.androidutnba.motionlayoututn.initmotion.InitDemoActivity
import com.androidutnba.motionlayoututn.layout.DemoLayoutActivity
import com.androidutnba.motionlayoututn.propertyset.DemoPropertySetActivity
import com.androidutnba.motionlayoututn.transform.DemoTranformActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.init).setOnClickListener {
            startActivity(Intent(this, InitDemoActivity::class.java))
        }

        findViewById<Button>(R.id.customAttribute).setOnClickListener {
            startActivity(Intent(this, CustomAttributeDemoActivity::class.java))
        }

        findViewById<Button>(R.id.demoLayout).setOnClickListener {
            startActivity(Intent(this, DemoLayoutActivity::class.java))
        }

        findViewById<Button>(R.id.propertySet).setOnClickListener {
            startActivity(Intent(this, DemoPropertySetActivity::class.java))
        }

        findViewById<Button>(R.id.transform).setOnClickListener {
            startActivity(Intent(this, DemoTranformActivity::class.java))
        }

        findViewById<Button>(R.id.fulldemo).setOnClickListener {
            startActivity(Intent(this, FullDemoActivity::class.java))
        }
    }
}