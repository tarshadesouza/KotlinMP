package com.example.gittest

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}