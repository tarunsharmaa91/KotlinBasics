package com.app.kotlinbasics.basics

class KotlinBasics {
    fun basicFunctions() {
        val i = "abc"
        val array = arrayListOf(1, 2, 3)
        array.add(4)
        println("Print value $i")
        println("Array values $array")

        val value = conditionStatement(1, 2)
        println("Here is returned value $value")

        switchStatement(20)

        forLoopExample(arrayListOf(10, 20, 30, 40, 50))
    }

    private fun forLoopExample(array: List<Int>){
        //Just to print current value
        for (i in array) println("Current value is $i")

        //To Print current value and index
        for ((index, value) in array.withIndex()) {
            println("Current index is $index and current value is $value")
        }

        //Below is example of while and do while loop

        var i = 10
        while (i < 20) {
            println("While loop current value is $i")
            if(i==15){
                break
            }
            i++
        }

        var x = 10
        do {
            x += 2
            println("This is do while loop $x")
        } while (x < 20)
    }

    private fun switchStatement(i: Int) {
        when (i) {
            1 -> println("abc")
            2 -> println("def")
            3, 4, 5, 20 -> println("When statement final value is bfh")
            else -> {
                println("When statement final value is $i")
            }
        }
    }

    private fun conditionStatement(i: Int, i1: Int) : Int{
        var c: Int
        // Var can be assigned multiple times
        if (i > i1) {
            c = i
        } else {
            c = i1
        }
        c = c + 1
        //Above statement will work in case of var but val is immutable(final) so
        // you can't assign to final variable again
        println("Value of c is $c")
        return c
    }
}