package chapter11

//var count = 0
//val reentrantLock = ReentrantLock()
//
//fun main() = runBlocking<Unit> {
//    withContext(Dispatchers.Default) {
//        repeat(10_000) {
//            launch {
//                reentrantLock.lock() // 쓰레드 블로킹
//                count += 1
//                reentrantLock.unlock()
//            }
//        }
//    }
//
//    println("count = ${count}")
//}