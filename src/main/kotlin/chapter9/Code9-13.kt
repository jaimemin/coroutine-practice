package chapter9

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val results = searchByKeywordAsyncSupervisorScope("Keyword")
    println("[결과] ${results.toList()}")
    println(getElapsedTime(startTime))
}

suspend fun searchByKeywordAsyncSupervisorScope(keyword: String): Array<String> = supervisorScope {
    val dbResultsDeferred = async {
        throw Exception("dbResultsDeferred에서 예외가 발생했습니다")

        searchFromDB(keyword)
    }

    val serverResultsDeferred = async {
        searchFromServer(keyword)
    }

    val dbResults = try {
        dbResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf() // 예외 발생 시 빈 결과 반환
    }

    val serverResults = try {
        serverResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf()
    }

    return@supervisorScope arrayOf(*dbResults, *serverResults)
}
