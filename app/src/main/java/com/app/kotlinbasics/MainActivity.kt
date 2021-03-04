package com.app.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.kotlinbasics.basics.KotlinBasics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KotlinBasics().basicFunctions()
    }
}