package com.app.kotlinbasics.sealedclassexample

sealed class SealedClass {

    class one : SealedClass()
    class two : SealedClass()

}