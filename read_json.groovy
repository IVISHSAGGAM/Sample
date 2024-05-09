import groovy.json.JsonSlurper

// Path to your JSON file
def jsonFilePath = 'example.json'

// Create a JsonSlurper instance
def jsonSlurper = new JsonSlurper()

// Read the file and parse its content
def data = jsonSlurper.parse(new File(jsonFilePath))

// Now 'data' holds the parsed JSON as a list of maps
// You can iterate over it or access it like any other list or map in Groovy

data.each { person ->
    println "ID: ${person.id}, Name: ${person.name}, Email: ${person.email}, Age: ${person.age}"
}
