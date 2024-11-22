package chapter11

//var count2 = AtomicInteger(0)
//
//fun main() = runBlocking<Unit> {
//    withContext(Dispatchers.Default) {
//        repeat(10_000) {
//            launch {
//                count2.getAndUpdate {
//                    it + 1
//                }
//            }
//        }
//    }
//
//    println("count = ${count2}")
//}