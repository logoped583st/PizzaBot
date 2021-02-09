package com.logoped583st.pizza_console

import com.logoped583st.pizza_core.controllers.PathController
import com.logoped583st.pizza_core.di.initKoin

import org.koin.java.KoinJavaComponent.inject

fun main(args: Array<String>) {

    initKoin()

    val pathController: PathController by inject(PathController::class.java)

    val input = if (args.isNotEmpty()) {
        args.joinToString("") { it }
    } else {
        println("Enter your path")
        readLine()!!
    }
    try {
        pathController.getPath(input).path.forEach {
            print(it.side)
        }
        println()
    } catch (e: Exception) {
        println(e.message)
    }

}

