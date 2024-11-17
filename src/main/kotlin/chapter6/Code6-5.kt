package chapter6

import kotlinx.coroutines.Dispatchers

fun main() {
    val dispatcherKey1 = Dispatchers.IO.key
    val dispatcherKey2 = Dispatchers.Default.key

    println("dispatcherKey1과 dispatcherKey2는 동일한가 >> ${dispatcherKey1 === dispatcherKey2}")
}