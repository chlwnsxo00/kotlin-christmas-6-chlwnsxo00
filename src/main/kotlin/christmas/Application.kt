package christmas

import christmas.controller.Controller

fun main() {
    val controller = Controller()
    try {
        controller.run()
    }catch (e:Exception){
        println(e.message)
    }
}
