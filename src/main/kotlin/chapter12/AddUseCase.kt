package chapter12

class AddUseCase {
    fun add(vararg args: Int): Int {
        return args.sum()
    }
}