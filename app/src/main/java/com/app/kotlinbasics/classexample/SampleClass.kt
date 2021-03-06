package com.app.kotlinbasics.classexample

class SampleClass {
    val message = "Test"
    fun printNo() {
        println("Hello")
    }

    //It is inside Sample Class and its method can't access message data member
    class NestedClass {
        fun printNestedClassMethod() {
            println("Nested Method")
        }
    }

    //It can access data member of outer class
    inner class InnerClass {
        fun printInnerMethod() {
            println("Inner class method $message")
        }
    }

}