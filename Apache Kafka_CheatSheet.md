

# Apache Kafka


### Setting up Kafka Cluster
#### Creating Single-Nodes-Multiple broker cluster.
 1. Download Apache Kafka from site: [http://kafka.apache.org/](http://kafka.apache.org/)
 2. C:\kafka_2.11-0.9.0.1\config\server.properties
 
    

> broker.id=0
>     port=9091
>     log.dirs=C:\kafka_2.11-0.9.0.1\kafka-log-1
>     zookeeper.connect=localhost:2181

Similarly create second broker configuration(server2.properties) with different broker id, port and log dirs.

### Starting zookeeper 
> bin/zookeeper-server-start.sh config/zookeeper.properties
### Starting brokers
> bin/kafka-server-start.sh config/server1.properties
>  bin/kafka-server-start.sh config/server2.properties

### Creating topics
Create topics with 2 partitions and 2 replication factors as we have two broker now.
> **bin/kafka-topics.sh --zookeeper localhost:2181 --create --topic test-topic --partition 2 --replication-factor 2**

### Checking Topic and paritions summary

> bin/kafka-topics.sh --zookeeper localhost:2181 --describe -- topic test-topic
### Creating a producer and send message
> bin/kafka-console-producer.sh --broker-list locahost:9092 --topic test-topic
> This is test-topic message
### Creating a consumer and consume message
> bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test-topic - [Options]
> Options: 
 - from-beginning - To consume from the beginning 
 
### Publishing Key value message
>kafka-console-producer  --broker-list localhost:9092 --topic ProfileChanged-topic --property  "parse.key=true" --property "key.separator=:"
  >Key:value
### Reading message starting from an offset
>kafka-console-consumer --bootstrap-server localhost:9092 --topic ProfileChanged-topic  --partition 0 --offset 117954
### Reading message with consumer group
>kafka-console-consumer --bootstrap-server localhost:9092 --topic ProfileChanged-topic --group profile-sync-bo

### Reset consumer offset  to latest

>kafka-consumer-groups --bootstrap-server localhost:9092 ProfileChanged-topic --group ProfileSync-bo --reset-offsets --to-latest
### Truncating a topic
> kafka-delete-records --bootstrap-server localhost:9092 --offset-json-file ./deltopic.json

~~~
deltopic.json

{"partitions":
[{"topic": "profilechanged", "partition": 0,
"offset": -1}],
"version":1
}
~~~
### Kafka consumer group check  Offset status

>kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group ProfileSync-BO

 
