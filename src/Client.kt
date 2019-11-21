package objectPool

class Client {
    private val pool = Pool(client = this)

    fun nav() {
        pool.nav()
    }
}