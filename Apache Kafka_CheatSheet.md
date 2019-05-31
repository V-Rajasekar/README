

# Apache Kafka
1. [Setup Kafka Cluster](#Setup)
2. [Kafka Topic](#Topic)
	   a. [Read from an Offset](#Offset)
3. [Kafka Producer](#Producer)
4. [Kafka Consumer](#Consumer)
		a. [Read from an Offset](#Offset)
		b. [Read for a consumer in group](#ConsumerGroup)
		c. [Consumer offset status](#ConsumerOffsetStatus)
		d. [Reset consumer offset](#ResetOffset)
5. [KafkaCat](#KafkaCat)
		
<a name="Setup"></a>
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
<a name="Topic"></a>
### Creating topics
Create topics with 2 partitions and 2 replication factors as we have two broker now.
> **bin/kafka-topics.sh --zookeeper localhost:2181 --create --topic test-topic --partition 2 --replication-factor 2**

### Checking Topic and paritions summary

> bin/kafka-topics.sh --zookeeper \<hostname\>:2181 --describe -- topic test-topic
<a name="Alter kafka topic config"></a>
### Alter kafka topic config to log compact (archieve old message)
#### Delete kafka topic config
> kafka-configs --zookeeper dev-msg01:2181  --entity-type topics --entity-name test-topic --alter --delete-config cleanup.policy

#### Add Kafka topic config 
> kafka-configs --zookeeper dev-msg01:2181  --entity-type topics --entity-name test-topic --alter --add-config cleanup.policy=compact

<a name="Producer"></a>
### Creating a producer and send message
> bin/kafka-console-producer.sh --broker-list locahost:9092 --topic test-topic
> This is test-topic message
### Publishing Key value message
>kafka-console-producer  --broker-list \<hostname\>:9092 --topic ProfileChanged-topic --property  "parse.key=true" --property "key.separator=:"
  >Key:value
<a name="Consumer"></a>
### Creating a consumer and consume message
> bin/kafka-console-consumer.sh --zookeeper \<hostname\>:2181 --topic test-topic - [Options]
> Options: 
 - from-beginning - To consume from the beginning 
<a name="Offset"></a>
 ### Reading message starting from an offset
>kafka-console-consumer --bootstrap-server \<hostname\>:9092 --topic ProfileChanged-topic  --partition 0 --offset 117954
<a name="ConsumerGroup"></a>
### Reading message with consumer group
>kafka-console-consumer --bootstrap-server \<hostname\>:9092 --topic ProfileChanged-topic --group profile-sync-bo
<a name="ConsumerOffsetStatus"></a>
### Kafka consumer group check  Offset status

>kafka-consumer-groups --bootstrap-server \<hostname\>:9092  --group profile-sync-amadeus --describe

<a name="ResetOffset"></a>
### Reset consumer offset  to latest
#### Reset offset to the latest (preview)
>kafka-consumer-groups --bootstrap-server \<hostname\>:9092 ProfileChanged-topic --group ProfileSync-bo --reset-offsets --to-latest
`The above command allows you to preview the (new)resetOffset appending --execute is the one acutally reset the offset`
#### Reset offset to the earliest
>kafka-consumer-groups --bootstrap-server \<hostname\>:9092 --topic no.norwegian.profile.event.ProfileChanged --group profile-sync-amadeus --reset-offsets --to-earliest --execute
#### Reset offset to a given offset
>kafka-consumer-groups --bootstrap-server nas-messaging01:9092 --topic no.norwegian.profile.event.ProfileChanged --group profile-sync-amadeus --reset-offset --to-offset 0 --execute

<a name="DeleteRecords"></a>
### Truncating a topic
> kafka-delete-records --bootstrap-server \<hostname\>:9092 --offset-json-file ./deltopic.json

~~~
deltopic.json

{"partitions":
[{"topic": "profilechanged", "partition": 0,
"offset": -1}],
"version":1
}
~~~
<a name="KafkaCat"></a>
### KafkaCat
kafkacat is a command line utility that you can use to test and debug Apache Kafka® deployments. You can use kafkacat to produce, consume, and list topic and partition information for Kafka. Described as "netcat for Kafka", it is a swiss-army knife of tools for inspecting and creating data in Kafka.
For more details: [https://github.com/edenhill/kafkacat](https://github.com/edenhill/kafkacat)
#### To see topic meta data
> kafkacat -b dev-msg01:9092 -t no.norwegian.reservation.api.PurchaseOrderCancelEvent.DLQ -L
#### To public record in kafka topic
> kafkacat -b dev-msg01:9092 -t no.norwegian.reservation.api.PurchaseOrderCancelEvent.DLQ -P -K: 
>\<key\>:\<value\>
#### To Read message from a offset and limit the records
 > kafkacat -b dev-msg01:9092 -C -t no.norwegian.profile.event.ProfileChanged-dev -o beginning -c 1
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE1ODE1MzIwMzgsMjE1MzA1OTUyLDE4Nz
kwNjY4NjQsLTEzMTA1NjA2OThdfQ==
-->