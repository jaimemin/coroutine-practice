package chapter3

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.newFixedThreadPoolContext

val multiThreadDispatcher: CoroutineDispatcher = newFixedThreadPoolContext(2, "MultiThread")