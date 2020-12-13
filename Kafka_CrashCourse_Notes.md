# Setting Up Kafka

<details><summary>Mac</summary>
<p>

- Make sure you are navigated inside the bin directory.

## Start Zookeeper and Kafka Broker

-   Start up the Zookeeper.

```
./zookeeper-server-start.sh ../config/zookeeper.properties
```

- Add the below properties in the server.properties

```
listeners=PLAINTEXT://localhost:9092
auto.create.topics.enable=false
```

-   Start up the Kafka Broker

```
./kafka-server-start.sh ../config/server.properties
```

## How to create a topic?

```
./kafka-topics.sh --create --topic test-topic -zookeeper localhost:2181 --replication-factor 3 --partitions 4
```

## How to instantiate a Console Producer?

### Without Key

```
./kafka-console-producer.sh --broker-list localhost:9092 --topic test-topic
```

### With Key

```
./kafka-console-producer.sh --broker-list localhost:9092 --topic test-topic --property "key.separator=-" --property "parse.key=true"
```

## How to instantiate a Console Consumer?

### Without Key

```
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic --from-beginning
```

### With Key

```
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic --from-beginning -property "key.separator= - " --property "print.key=true"
```

### With Consumer Group

```
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic --group <group-name>
```
</p>

</details>

<details><summary>Windows</summary>
<p>

- Make sure you are inside the **bin/windows** directory.

## Start Zookeeper and Kafka Broker

-   Start up the Zookeeper.

```
zookeeper-server-start.bat ..\..\config\zookeeper.properties
```

-   Start up the Kafka Broker.

```
kafka-server-start.bat ..\..\config\server.properties
```

## How to create a topic ?

```
kafka-topics.bat --create --topic test-topic -zookeeper localhost:2181 --replication-factor 1 --partitions 4
```

## How to instantiate a Console Producer?

### Without Key

```
kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic
```

### With Key

```
kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic --property "key.separator=-" --property "parse.key=true"
```

## How to instantiate a Console Consumer?

### Without Key

```
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning
```

### With Key

```
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning -property "key.separator= - " --property "print.key=true"
```

### With Consumer Group

```
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --group <group-name>
```
</p>

</details>

## Setting Up Multiple Kafka Brokers

- The first step is to add a new **server.properties**.

- We need to modify three properties to start up a multi broker set up.

```properties
broker.id=<unique-broker-d>
listeners=PLAINTEXT://localhost:<unique-port>
log.dirs=/tmp/<unique-kafka-folder>
auto.create.topics.enable=false
```

- Example config will be like below.

```properties
broker.id=1
listeners=PLAINTEXT://localhost:9093
log.dirs=/tmp/kafka-logs-1
auto.create.topics.enable=false
```

### Starting up the new Broker

- Provide the new **server.properties** thats added.

```
./kafka-server-start.sh ../config/server-1.properties
```

```
./kafka-server-start.sh ../config/server-2.properties
```

# Advanced Kafka CLI operations:

<details><summary>Mac</summary>
<p>

## List the topics in a cluster

```
./kafka-topics.sh --zookeeper localhost:2181 --list
```

## Describe topic

- The below command can be used to describe all the topics.

```
./kafka-topics.sh --zookeeper localhost:2181 --describe
```

- The below command can be used to describe a specific topic.

```
./kafka-topics.sh --zookeeper localhost:2181 --describe --topic <topic-name>
```

## Alter the min insync replica
```
./kafka-topics.sh --alter --zookeeper localhost:2181 --topic library-events --config min.insync.replicas=2
```

## Delete a topic

```
./kafka-topics.sh --zookeeper localhost:2181 --delete --topic test-topic
```
## How to view consumer groups

```
./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
```

### Consumer Groups and their Offset

```
./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group console-consumer-27773
```

## Viewing the Commit Log

```
./kafka-run-class.sh kafka.tools.DumpLogSegments --deep-iteration --files /tmp/kafka-logs/test-topic-0/00000000000000000000.log
```

## Setting the Minimum Insync Replica

```
./kafka-configs.sh --alter --zookeeper localhost:2181 --entity-type topics --entity-name test-topic --add-config min.insync.replicas=2
```
</p>
</details>


<details><summary>Windows</summary>
<p>

- Make sure you are inside the **bin/windows** directory.

## List the topics in a cluster

```
kafka-topics.bat --zookeeper localhost:2181 --list
```

## Describe topic

- The below command can be used to describe all the topics.

```
kafka-topics.bat --zookeeper localhost:2181 --describe
```

- The below command can be used to describe a specific topic.

```
kafka-topics.bat --zookeeper localhost:2181 --describe --topic <topic-name>
```

## Alter the min insync replica
```
kafka-topics.bat --alter --zookeeper localhost:2181 --topic library-events --config min.insync.replicas=2
```


## Delete a topic

```
kafka-topics.bat --zookeeper localhost:2181 --delete --topic <topic-name>
```


## How to view consumer groups

```
kafka-consumer-groups.bat --bootstrap-server localhost:9092 --list
```

### Consumer Groups and their Offset

```
kafka-consumer-groups.bat --bootstrap-server localhost:9092 --describe --group console-consumer-27773
```

## Viewing the Commit Log

```
kafka-run-class.bat kafka.tools.DumpLogSegments --deep-iteration --files /tmp/kafka-logs/test-topic-0/00000000000000000000.log
```
</p>
</details>

# Kafka Topic and Partitions
<details><summary>Kafka Topic</summary>
<p>
- Kafka Topic is an entity in Kafka broker
- A Kafka broker can have one or more kafka topics
- Kafka producer and consumer uses topic to publish and consume messages from a topic
- An topic name is used to publish and consume message from a topic
- Consumer polls the broker using topic name to consume message at a regular interval
- Once publisher publish the message using topic name the message resides in topic and consumer polls continueously for new message using the topic name.
- Eventhough the message is read by the consumer the message still resides inside the topic depending on the retention period.
</p>
</details>
<details><summary>Partition</summary>

- Partition is where the message lives inside the topic
- Each topic will be created with 1 or more paritions
- The paritions have significant effect on scaleable message consumptions.
- Each parition is an ordered, immutable sequence of records
- Each record is assgined a sequential number called **offset**
an offset is created once an message/record is published in a topic.
- Each partition is independent of each other.
- Ordering is guaranteed only at the partition level. if you usecase if you would like publish and read record at certain order then you have to publish the record in the same paritions.
- All the records are persisted in a commit log in the file system where kafka is installed. its a distributed log file.

</details>

<details><summary>Consumer Offsets</summary>

- Consumer have three options to read
    -  from-beginning
    -  latest
    -  specific offset (possible only through programatically or through KafkaCat)
 -  consumer offsets are stored under an internal kafka topic(__consumer_offsets) with a groupid
 -  consumer offsets behaves like a bookmark for the consumer to start reading the messages from the point it left off.
 
</details>
<details><summary>Consumer Groups</summary>
 
  - *group.id* is mandatory
  - *group.id* plays a major role when it comes to scalable message consumption.
  - Consumer Groups are used for scalable message consumption
  - Each different application will have a unique consumer group
  - who manages the consumer group?
    - Kafka Broker manages the consumer-groups
    - Kafka Broker acts as a Group Co-ordinator
  - To list kafka consumer
  > ./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
</details>
<details><summary>Commit Log and Retention Policy</summary>
 
 - *Commit Log*
   - when a publisher publishes a message to a kafka topic the message in commit to a log file this log file config path (*`log.dir`*) is configured in `server.properties`
   - Every partition will have its own partition commit log file and this log files are stored in kafka broker installed machine.
   - A consumer can read records which are committed in the log files and the messages are written in byte format in the log file.
- *Retention Policy*
  - Determines how long the message is displayed ?
  - Configured using the property *`log.retention.hours`* in server.properties
</details>

# Kafka as a Distributed system
- what is a distributed system?</br>
  A distributed system is a collection of systems working together to deliver a value.</br>
  ### Characterictics of distributed system
  - Availability and Fault Tolerance
  - Reliable Work Distribution
  - Easily Scalable
  - Handling Concurrency is fairly easy
- Kafka Cluster
  - Cluster will normally have one or more kafka broker and this broker are managed by zookeeper.
  - All the brokers send heart beat to the cluster mananger(zookeeper) at regular interval to ensure the state of the broker is healthy and active to serve the client requests.
  - If one of the broker is down its notified to zookeeper and all the client request is redirect to other active brokers.
  - Easy to scale by adding more brokers based on the need.
  - Handles data loss using Replication
[Setting Up Multiple Kafka Brokers](#-Setting-Up-Multiple-Kafka-Brokers)

# How Kafka Distributes the Client Requests?
## How Topics are distributed ?
Let consider a Kafka cluster with 3 kafka brokers.Out of the 3 broker one of the broker as a controller. When the create topic command is issued to zookeeper it redirect the command to the controller.

The role of the controller(broker) is to distribute the paritions evenly to the available brokers (e.g) parition of 3 then broker-1: Partition-0, broker-2: Partition-1, broker-3: Partition-2
broker-1 is the leader of the parition-0 and the messages in the parition-0 are replicated in the other brokers as well.

## Kafka Producer
Producer has a layer called partitioner which takes care of determining which partition the message is going to go. Producer send the message to partitioner before the message goes to topic and paritioner resolves in which partition the message should go.

## Kafka Consumer
When the poll loop is executed the request goes to all the partition leaders and retrieved the record from them and the retrieved records are handed to consumer to process.
The client call goes only to the partition leaders. If there are one or more instances of the consumer with the same consumer group id then the partition are distributed for scalable purpose so here partition-0, partition-1 and partition-2 are distributed to 3 kafka consumer if there are 3 instances of kafka consumers with same consumer group id.

## Summary
- Parition leaders are assigned during the topic creation
- Clients will only invoke leader of the partition to produce and consume data
  - Load is evenly distributed between the brokers

# How Kafka handles Data Loss in the event of Kafka broker failure? 
Kafka handles the data loss using replication. Remember when you create a topic [Create topic](#-How-to-create-a-topic?) you mention the  `--replication-factor` this creates the leader-replicator and follower-replicator across the available brokers. If you have 3 brokers you can have max=3 

## In-Sync Replica(ISR)
- Represents the number of replica in sync with each other in the cluster
  - Includes both *leader* and *follower* replica
  - Recommended value is always greater than 1
  - Ideal value is **ISR == Replication** Factor
  - This can be controlled by min.insync. replicas property
    - It can be set at the *broker* or *topic* level

Advanced setup `min.insync.replica` value as 2 it will make sure the data is produced to the topic only when two brokers are available.
# Kafka Admin
<details><summary>Kafka Admin</summary>
- create topics programmatically.
- Part of **SpringKafka**
- How to create a topic from Code ? 
  - create a Bean of type **KafkaAdmin** in spring configuration
  - Create a Bean of type **NewTopic** in SpringConfiguration
  
</details>
<details><summary></summary>
</details>
<details><summary></summary>
</details>

## Spring for Apache Kafka
### Quick start
1. Google search `spring for Apache Kafka`
2. Go to https://docs.spring.io/spring-kafka/docs/2.5.9.RELEASE/reference/html/