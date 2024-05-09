// Define a map with some initial programming languages and their popularity ratings
def languagePopularity = ['Java': 1, 'Python': 2, 'JavaScript': 3]

// containsKey(): Check if the map contains a specific key (language)
println "Contains key 'Java'? ${languagePopularity.containsKey('Java')}"

// get(): Retrieve the popularity rating associated with a specific language
println "Popularity of 'Python': ${languagePopularity.get('Python')}"

// keySet(): Get the set of programming languages in the map
println "All programming languages: ${languagePopularity.keySet()}"

// put(): Add a new programming language to the map or update the rating of an existing language
languagePopularity.put('C#', 4)
println "Updated map with 'C#': $languagePopularity"

// size(): Returns the number of programming languages in the map
println "Number of languages in the map: ${languagePopularity.size()}"

// values(): Get the collection of popularity ratings in the map
println "All popularity ratings: ${languagePopularity.values()}"

// Demonstrating put() to update an existing language's popularity rating
languagePopularity.put('Java', 5) // Update the popularity rating of 'Java'
println "Updated popularity of 'Java': ${languagePopularity.get('Java')}"

// Direct access to map values using keys
println "Direct access - Popularity of 'JavaScript': ${languagePopularity['JavaScript']}"
