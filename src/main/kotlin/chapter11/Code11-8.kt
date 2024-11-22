package chapter11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicReference

data class Counter(val name: String, val count: Int)

val atomicCounter = AtomicReference(Counter("MyCounter", 0))

fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                atomicCounter.getAndUpdate {
                    it.copy(count = it.count + 1)
                }
            }
        }
    }

    println(atomicCounter.get())
}