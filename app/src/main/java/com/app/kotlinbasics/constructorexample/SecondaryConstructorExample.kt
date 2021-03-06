package com.app.kotlinbasics.constructorexample

class SecondaryConstructorExample(var firstName: String, var age: Int) {

    var message = "Testing"

    constructor(d: String, bi: Int, message: String) : this(d, bi) {

    }
}