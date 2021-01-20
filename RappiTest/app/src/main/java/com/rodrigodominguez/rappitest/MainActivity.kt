package com.rodrigodominguez.rappitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.rodrigodominguez.rappitest.databinding.MainActivityBinding
import com.rodrigodominguez.rappitest.listfilms.ui.FilmsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val binding = MainActivityBinding.inflate(LayoutInflater.from(this))
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, FilmsFragment.newInstance())
                .commitNow()
        }
    }
}