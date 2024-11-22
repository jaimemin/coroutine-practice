package chapter9

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    // launch 블록에서 suspend 함수 호출
    launch {
        val keywords = searchByKeyword("Kotlin")

        for (keyword in keywords) {
            println(keyword)
        }
    }

    println(getElapsedTime(startTime))
}

// suspend 함수로 정의
suspend fun searchByKeyword(keyword: String): Array<String> {
    val dbResults = searchFromDB(keyword)
    val serverResults = searchFromServer(keyword)

    return arrayOf(*dbResults, *serverResults)
}

suspend fun searchFromDB(keyword: String): Array<String> {
    delay(1000L)

    return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}

suspend fun searchFromServer(keyword: String): Array<String> {
    delay(1000L)

    return arrayOf("[Server]${keyword}1", "[Server]${keyword}2")
}

fun getElapsedTime(startTime: Long): String {
    val elapsedTime = System.currentTimeMillis() - startTime
    return "Elapsed time: ${elapsedTime}ms"
}
