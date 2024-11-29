package chapter12

interface UserNameRepository {

    fun saveUserName(id: String, name: String)

    fun getNameByUserId(id: String): String
}