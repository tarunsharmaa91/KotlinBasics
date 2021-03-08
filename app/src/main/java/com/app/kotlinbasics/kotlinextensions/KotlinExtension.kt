package com.app.kotlinbasics.kotlinextensions

class KotlinExtension {

    var a: String = "null"

    fun printSkill() {
        println(a)
    }

    fun addSkills(c: KotlinExtension): String {
        val z = KotlinExtension()
        z.a = this.a + " " + c.a
        return z.a
    }

}