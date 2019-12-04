package objectPool

import java.util.*

class Pool {
    // The Pool (can be Singleton or Multiton )
    companion object Pool {
        private var freeObjects: Queue<DBObject> = LinkedList<DBObject>()
        private var busyObjects: Queue<DBObject> = LinkedList<DBObject>()
        private const val MAX_NUM_OF_OBJECTS: Int = 3

        init {
            println("Creating a Pool...")
            println("Pool ${this.hashCode()} created.\n")
        }
    }

    // Client requests for an object
    private fun getObject() {
        if (freeObjects.isEmpty()) {
            if (busyObjects.size == MAX_NUM_OF_OBJECTS) { // or we can do resize
                println("\n-> No free object. Pool is full. Please try back.")
            } else {
                val obj = DBObject()
                busyObjects.add(obj)
                println("\n-> Here is your object: ${obj.hashCode()}")
            }
        } else {
            val obj = freeObjects.remove()
            obj.state = 1 // set its state
            busyObjects.add(obj)
            println("\n-> Here is your object: ${obj.hashCode()}")
        }

        listObjects()
    }

    // Should we just reset the state or destroy it???
    private fun returnObject() {
        if (busyObjects.isEmpty()) {
            println("\n-> Nothing to return.")
        } else {
            val obj = busyObjects.remove()
            obj.state = 0 // reset its state
            freeObjects.add(obj)
            println("\n-> Object's state has been cleared. Object coming back to the pool.")
        }

        listObjects()
    }

    // List all objects in the pool
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

    // Navigation
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