import groovy.sql.Sql

/*
Install and configure mysql on ubuntu
https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04

wget https://cdn.mysql.com/archives/mysql-connector-java-8.0/mysql-connector-j_8.0.31-1ubuntu22.04_all.deb
Run the following command
groovy -cp ~/.groovy/grapes/com.mysql/mysql-connector-j/jars/mysql-connector-j-8.0.31.jar test.groovy
*/

class DatabaseConnector {
    private String url
    private String user
    private String password
    private String driver

    DatabaseConnector(String url, String user, String password, String driver) {
        this.url = url
        this.user = user
        this.password = password
        this.driver = driver
    }

    void connectToDatabase() {
        try {
            Sql sql = Sql.newInstance(url, user, password, driver)
            println 'Successfully connected to the database.'
            // Perform database operations here
            // For demonstration, we'll just close the connection
            sql.close() // Close the connection
        } catch (Exception e) {
            e.printStackTrace()
            println 'Failed to connect to the database.'
        }
    }
}

// Usage
def databaseConnector = new DatabaseConnector(
    'jdbc:mysql://localhost:3306/testdb', // Change 'testdb' to your actual database name
    'root', // Change to your MySQL username
    'password', // Change to your MySQL password
    'com.mysql.cj.jdbc.Driver' // JDBC driver
)

databaseConnector.connectToDatabase()
