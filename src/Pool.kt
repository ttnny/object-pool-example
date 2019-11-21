package objectPool

import java.util.*

class Pool(
    private val client: Client
) {

    // The Pool (Singleton)
    companion object Pool {
        private var freeObjects: Queue<Object> = LinkedList<Object>()
        private var busyObjects: Queue<Object> = LinkedList<Object>()
        private const val MAX_NUM_OF_OBJECTS: Int = 3

        init {
            println("Creating a Pool (Singleton)...")
            println("Pool ${this.hashCode()} created.\n")
        }
    }

    // Client requests for an object
    private fun getObject() {
        if (freeObjects.isEmpty()) {
            if (busyObjects.size == MAX_NUM_OF_OBJECTS) { // or we can do resize
                println("\n-> No free object. Pool is full. Please try back.\n")
            } else {
                val obj = Object()
                busyObjects.add(obj)
                println("\n-> Here is your object: ${obj.hashCode()}\n")
            }
        } else {
            val obj = freeObjects.remove()
            busyObjects.add(obj)
            println("\n-> Here is your object: ${obj.hashCode()}\n")
        }

        nav()
    }

    // Should we just reset the state or destroy it???
    private fun returnObject() {
        if (busyObjects.isEmpty()) {
            println("\n-> Nothing to return.\n")
        } else {
            freeObjects.add(busyObjects.remove())
            println("\n-> Object's state has been cleared. Object coming back to the pool.\n")
        }

        nav()
    }

    // List all objects in the pool
    private fun listObjects() {
        println("\n------------- TOTAL OBJECTS in POOL -------------")
        print("Free Objects: ")
        for (obj in freeObjects) {
            print(obj.hashCode())
        }
        println()

        print("Busy Objects: ")
        for (obj in busyObjects) {
            print("${obj.hashCode()}, ")
        }
        println("\n-------------------------------------------------\n")

        nav()
    }

    // Navigation
    fun nav() {
        println("Menu Options for Client ${client.hashCode()}")
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