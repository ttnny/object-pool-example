package objectPool

/**
 * Demonstration class
 */
fun main() {
    val client1 = Client()
    client1.nav()

    // Create client2 to demonstrate that
    // the objects remains the same
    // and no new pool is created
    val client2 = Client()
    client2.nav()
}