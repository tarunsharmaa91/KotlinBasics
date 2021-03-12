package com.app.kotlinbasics.generics

class GenericExample<T>(input: T) {
    init {
        println("$input")
    }
}