import groovy.json.JsonSlurper

// Path to the JSON file
def jsonFilePath = 'users.json'

// Reading the JSON file
File jsonFile = new File(jsonFilePath)
JsonSlurper jsonSlurper = new JsonSlurper()
def users = jsonSlurper.parse(jsonFile)

// Iterating over each user and printing all key-value pairs
users.each { user ->
    user.each { key, value ->
        println "${key.capitalize()}: $value"
    }
    println "-" * 20 // Adding a separator for readability
}
