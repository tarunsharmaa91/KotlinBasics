package com.app.kotlinbasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.kotlinbasics.basics.KotlinBasics
import com.app.kotlinbasics.classexample.SampleClass
import com.app.kotlinbasics.constructorexample.ConstExample
import com.app.kotlinbasics.constructorexample.SecondaryConstructorExample
import com.app.kotlinbasics.dataclass.DataClassExample
import com.app.kotlinbasics.generics.GenericExample
import com.app.kotlinbasics.inheritanceexample.ChildClass
import com.app.kotlinbasics.kotlinextensions.KotlinExtension
import com.app.kotlinbasics.kotlinextensions.ObjectExtension
import com.app.kotlinbasics.sealedclassexample.SealedClass

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

        //Call anonymous inner class or Interface example
        val callMethod: SampleInterface = object : SampleInterface { //Create object of interface
            override fun testMethod() {
                println("Example of anonymous inner class")
            }
        }
        callMethod.testMethod()

        //Primary Constructor Example
        ConstExample("Human", 25).test()

        //Secondary constructor example, when you want to add more logic to primary constructor
        val secondaryConstructorExample = SecondaryConstructorExample("abc", 30)
        println("${secondaryConstructorExample.age} ${secondaryConstructorExample.firstName} ${secondaryConstructorExample.message}")

        //Inheritance example
        ChildClass().mainMethod()

        //Kotlin function extension example (Add or remove some method without inheriting or modifying them)
        val b = KotlinExtension()
        b.a = "Java"

        val c = KotlinExtension()
        c.a = "Kotlin"

        val d = KotlinExtension()
        d.a = b.addSkills(c)
        d.printSkill()

        //Object extension is to implement static method in kotlin
        ObjectExtension.printValue()

        //Data class example
        val value = DataClassExample("This is data class")
        println("$value.name")

        //Sealed class example
        val sealedClass: SealedClass = SealedClass.one()
        val output = when(sealedClass){
            is SealedClass.one -> "First sealed class"
            is SealedClass.two -> "Second sealed class"
        }
        println(output)

        //Generic Example
        var abc = GenericExample("abc")
        var def = GenericExample(12)
        var defa = GenericExample(12.00)
    }

    interface SampleInterface {
        fun testMethod()
    }
}