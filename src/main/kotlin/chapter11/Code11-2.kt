package chapter11

//@Volatile
//var count = 0
//
//fun main() = runBlocking<Unit> {
//    withContext(Dispatchers.Default) {
//        repeat(10_000) {
//            launch {
//                count += 1
//            }
//        }
//    }
//
//    println("count = ${count}")
//}