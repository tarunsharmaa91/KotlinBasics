package com.app.kotlinbasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.kotlinbasics.basics.KotlinBasics
import com.app.kotlinbasics.classexample.SampleClass
import com.app.kotlinbasics.constructorexample.ConstExample
import com.app.kotlinbasics.constructorexample.SecondaryConstructorExample
import com.app.kotlinbasics.dataclass.DataClassExample
import com.app.kotlinbasics.delegation.Downloader
import com.app.kotlinbasics.delegation.Player
import com.app.kotlinbasics.destructuringdeclaration.Student
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
        val output = when (sealedClass) {
            is SealedClass.one -> "First sealed class"
            is SealedClass.two -> "Second sealed class"
        }
        println(output)

        //Generic Example
        var abc = GenericExample("abc")
        var def = GenericExample(12)
        var defa = GenericExample(12.00)

        //Delegation in Kotlin Example

        val file = "Song"
        val media = MediaFile(FileDownloader(file), FilePlayer(file))
        media.download()
        media.play()

        //Destructuring declaration: Declaring multiple variables at once
        val obj = Student("abc", "def")
        val(name, subject) = obj
        //Here name and subject are objects of student class
        println("$name $subject")
    }

    class FileDownloader(private val file: String) : Downloader {
        override fun download() {
            println("$file Downloaded")
        }
    }

    class FilePlayer(private val file: String) : Player {
        override fun play() {
            println("$file Play")
        }

    }

    //Delegation means delegating the responsibility to another object and we are implementing downloader and player interface here
    /*class MediaFile(private val downloader: Downloader, private val player: Player) : Downloader,
        Player {

        //We will be delegating the responsibility of download and play to downloader and player instance defined above

        override fun download() {
            downloader.download()
        }

        override fun play() {
            player.play()
        }

    }*/

    //Above overridden code is removed using delegation
    class MediaFile(private val downloader: Downloader, private val player: Player) :
        Downloader by downloader,
        Player by player {
    }

    interface SampleInterface {
        fun testMethod()
    }
}