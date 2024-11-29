package chapter12

class StubUserNameRepository(
    private val userNameMap: Map<String, String> // 데이터 주입
) : UserNameRepository {

    override fun saveUserName(id: String, name: String) {
        // TODO
    }

    override fun getNameByUserId(id: String): String {
        return userNameMap[id] ?: ""
    }
}