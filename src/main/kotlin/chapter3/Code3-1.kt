package chapter3

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.newSingleThreadContext

val dispatcher: CoroutineDispatcher = newSingleThreadContext(name = "SingleThread")