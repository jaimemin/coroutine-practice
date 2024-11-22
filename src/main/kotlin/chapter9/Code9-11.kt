package chapter9

// Unresolved reference async
/**
 * 일시 중단 함수에서 launch나 async 같은 코루틴 빌더 함수를 호출하기 위해서는 일시 중단 함수 내부에서 CoroutineScope에 접근 가능해야 한다
 */
//suspend fun searchByKeywordAsync(keyword: String): Array<String> {
//    val dbResultsDeferred = async {
//        searchFromDB(keyword)
//    }
//
//    val serverResultsDeferred = async {
//        searchFromServer(keyword)
//    }
//
//    return arrayOf(*dbResultsDeferred.await(), *serverResultsDeferred.await())
//}