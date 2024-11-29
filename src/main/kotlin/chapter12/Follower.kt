package chapter12

sealed class Follower(
    private val id: String,
    private val name: String
) {
    data class OfficialAccount(
        private val id: String,
        val name: String
    ) : Follower(id, name)

    data class PersonAccount(
        private val id: String,
        val name: String
    ) : Follower(id, name)
}