package chapter9

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    delayAndPrint(keyword = "I'm Parent Coroutine")

    launch {
        delayAndPrint(keyword = "I'm Child Coroutine")
    }
}