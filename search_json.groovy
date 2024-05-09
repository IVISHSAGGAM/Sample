import groovy.json.JsonSlurper

// Path to the JSON file
def jsonFilePath = 'users.json'

// Reading the JSON file
def jsonFile = new File(jsonFilePath)
def jsonSlurper = new JsonSlurper()
def userList = jsonSlurper.parse(jsonFile)

// Search criterion
def searchAge = 25

// Filtering users based on the search criterion
def filteredUsers = userList.findAll { user ->
    user.age > searchAge
}

// Printing the results
println "Users older than $searchAge:"
filteredUsers.each { user ->
    println "\tID: ${user.id}, Name: ${user.name}, Email: ${user.email}, Age: ${user.age}"
}

/* users.json
def jsonString = '''
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 30
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "email": "jane.smith@example.com",
    "age": 25
  },
  {
    "id": 3,
    "name": "Jim Bean",
    "email": "jim.bean@example.com",
    "age": 35
  }
]
*/