package objectPool

// On  (1) : working object
// Off (0) : free object
data class DBObject(var state: Int = 1) {
    override fun hashCode(): Int {
        return super.hashCode()
    }
}