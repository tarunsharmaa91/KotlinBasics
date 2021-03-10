package com.app.kotlinbasics.sealedclassexample

//Used to represent restricted class hierarchy
//Allow us to maintain data type of predefined type which we can't do in enum in java
//Can have sub class but should be defined in same kotlin file
//Can't have object
sealed class SealedClass {

    class one : SealedClass()
    class two : SealedClass()

}