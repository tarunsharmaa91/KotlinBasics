package com.app.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.kotlinbasics.basics.KotlinBasics
import com.app.kotlinbasics.classexample.SampleClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Data members
        KotlinBasics().basicFunctions()

        //Class Samples
        SampleClass().printNo()

        //Call Nested method, nested class is static and can be called without creating an object
        SampleClass.NestedClass().printNestedClassMethod()

        //Call Inner class method
        SampleClass().InnerClass().printInnerMethod()

        //Call anonymous inner class
        val callMethod: SampleInterface = object:SampleInterface{ //Create object of interface
            override fun testMethod() {
                println("Example of anonymous inner class")
            }
        }
        callMethod.testMethod()

    }

    interface SampleInterface{
        fun testMethod()
    }
}