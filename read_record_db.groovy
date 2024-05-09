import groovy.sql.Sql

// Function to establish a database connection
def getDatabaseConnection(url, user, password, driver) {
    try {
        Sql sql = Sql.newInstance(url, user, password, driver)
        println 'Successfully connected to the database.'
        return sql
    } catch (Exception e) {
        e.printStackTrace()
        println 'Failed to connect to the database.'
        return null
    }
}

// Function to read and print records from the employees table
def readEmployees(Sql sql) {
    if (sql) {
        String query = "SELECT id, name, position FROM employees"
        sql.eachRow(query) { row ->
            println "ID: ${row.id}, Name: ${row.name}, Position: ${row.position}"
        }
    } else {
        println "Invalid SQL connection. Cannot read employees."
    }
}

// Database connection parameters
def url = 'jdbc:mysql://localhost:3306/testdb' // Change 'testdb' to your actual database name
def user = 'root' // Change to your MySQL username
def password = 'password' // Change to your MySQL password
def driver = 'com.mysql.cj.jdbc.Driver'

// Establishing database connection
def sql = getDatabaseConnection(url, user, password, driver)

// Reading and printing employees records
readEmployees(sql)

// Don't forget to close the connection when done
if (sql) {
    sql.close()
}
