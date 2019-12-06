package objectPool

import java.util.*

/**
 * Object Pool Design Pattern
 * Participant: Pool
 */
class Pool {
    /**
     * The Pool
     * - A list of free objects
     * - A list of busy objects
     * - A maximum number of objects allowed
     */
    companion object Pool {

        init {
            println("Creating a Pool...")
            println("Pool ${this.hashCode()} created.\n")
        }
    }

    /**
     * Handle clients' requests for object(s)
     */
    private fun getObject() {

        listObjects()
    }

    /**
     * Handle returning object(s) from the clients
     * Real-world application, e.g. with a DB connection object:
     *      This method can be implemented to
     *      set a time-out for each object and
     *      collect any idle objects from the clients.
     */
    private fun returnObject() {

        listObjects()
    }

    /**
     * List all objects in the pool
     */
    private fun listObjects() {
        println("\n----------- TOTAL OBJECTS in POOL (MAX is $MAX_NUM_OF_OBJECTS) -----------")

        print(" Free Objects: ")
        for (obj in freeObjects) {
            print("${obj.hashCode()}(${obj.state}) ")
        }
        println()

        print(" Busy Objects: ")
        for (obj in busyObjects) {
            print("${obj.hashCode()}(${obj.state}) ")
        }
        println("\n--------------------------------------------------------\n")

        nav()
    }

    /**
     * Navigation for demonstration
     */
    fun nav() {
        println("Menu Options:")
        print(
            """
                1. Gimme an object
                2. Return the object
                3. List total objects in the pool
                4. Done with selection
                Please select an option: 
                """.trimIndent()
        )

        when (readLine()) {
            "1" -> getObject()
            "2" -> returnObject()
            "3" -> listObjects()
            "4" -> return
        }

        println()
    }
}