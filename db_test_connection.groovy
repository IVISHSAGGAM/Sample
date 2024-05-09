//@Grab(group='mysql', module='mysql-connector-java', version='8.0.31')
/*
Install and configure mysql on ubuntu
https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04

wget https://cdn.mysql.com/archives/mysql-connector-java-8.0/mysql-connector-j_8.0.31-1ubuntu22.04_all.deb
Run the following command
groovy -cp ~/.groovy/grapes/com.mysql/mysql-connector-j/jars/mysql-connector-j-8.0.31.jar test.groovy
*/
import groovy.sql.Sql

def url = 'jdbc:mysql://localhost:3306/testdb' // Change 'mydatabase' to your actual database name
def user = 'root' // Change to your MySQL username
def password = 'password' // Change to your MySQL password
def driver = 'com.mysql.cj.jdbc.Driver'

try {
    Sql sql = Sql.newInstance(url, user, password, driver)
    println 'Successfully connected to the database.'
    sql.close() // Close the connection
} catch (Exception e) {
    e.printStackTrace()
    println 'Failed to connect to the database.'
}