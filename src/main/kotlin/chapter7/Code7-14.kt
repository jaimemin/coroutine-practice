package chapter7

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val newScope = CoroutineScope(CoroutineName("MyCoroutine") + Dispatchers.IO)
    newScope.launch(CoroutineName("LaunchCoroutine")) {
        this.coroutineContext // LaunchCorotuine의 실행 환경을 CoroutineScope을 통해 접근
        this.launch {
            println(this.coroutineContext[CoroutineName])
            println(this.coroutineContext[CoroutineDispatcher])

            val launchJob = this.coroutineContext[Job]
            val newScopeJob = newScope.coroutineContext[Job]
            println("launchJob?.parent === newScopeJob >> ${launchJob?.parent === newScopeJob}")
        }
    }

    Thread.sleep(1000L)
}