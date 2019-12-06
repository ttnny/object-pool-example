package objectPool

/**
 * Object Pool Design Pattern
 * Participant: Reusable Object Class
 *      On  (1) : working object
 *      Off (0) : free object, its state has been reset
 */
data class DBObject(var state: Int = 1) {
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DBObject

        if (state != other.state) return false

        return true
    }
}