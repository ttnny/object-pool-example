package objectPool

/**
 * Object Pool Design Pattern
 * Participant: Client
 */
class Client {
    private val pool = Pool()

    fun nav() {
        println("Client ID ${this.hashCode()}")
        pool.nav()
    }
}