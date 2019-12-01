package objectPool

class Client {
    private val pool = Pool()

    fun nav() {
        println("Client ID ${this.hashCode()}")
        pool.nav()
    }
}