# Persistent state management with Vert.x
we’ll explore database and state management with Vert.x by diving into the implementation of the user and activity services. These services will allow us to use a document-oriented database (MongoDB) and a relational database (PostgreSQL).

The Eclipse Vert.x project provides the data client modules.These containes the drivers to connect to the database.
| Identifier                             | Description                                                                                 |
| -------------------------------------- | ------------------------------------------------------------------------------------------- |
| vertx-mongo-client                     | MongoDB is a document-oriented database.                                                    |
| vertx-jdbc-client                      | Supports any relational database that offers a JDBC driver.                                 |
| vertx-pg-client and vertx-mysql-client | Access PostgreSQL and MySQL relational databases through dedicated Vert.x reactive drivers. |
| vertx-redis-client                     | Redis is versatile data structure store.                                                    |
| vertx-cassandra-client                 | Apache Cassandra is a database tailored for very large volumes of data.                     |
