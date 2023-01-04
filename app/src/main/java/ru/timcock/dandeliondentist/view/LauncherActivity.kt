package ru.timcock.dandeliondentist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}