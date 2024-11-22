package chapter10

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun routine() {
    routineA() // routineA는 routine의 서브루틴
    routineB() // routineA는 routine의 서브루틴
}

fun routineA() {

}

fun routineB() {

}