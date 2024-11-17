package chapter6

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

val myJob = Job()
val coroutineContext: CoroutineContext = Dispatchers.IO + myJob