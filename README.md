# purchaseInfoService

Micro service which recevices the message from Kafka and savt it into HSQL (in-memory database)

project setup:

Download Kafka:
https://www.apache.org/dyn/closer.cgi?path=/kafka/2.3.0/kafka_2.12-2.3.0.tgz
(with inbuild inbuild zookeepr)

Make sure:
1.class path and Java home set in Env. variables
2.kafka_2.12-2.3.0 rename this folder name

Start Zookeeper:
zookeeper-server-start.bat .\config\zookeeper.properties

Start Kafka:
kafka-server-start.bat .\config\server.properties

Create Topic:
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic purchase-info-topic

Run:
PurchaseInfoApp

Use service URL to send test message:
http://localhost/kafkatest/sendmessage

Verify the DB console:
http://localhost/console

JDBC URL : jdbc:h2:mem:purchase_db
username : ismail
password : 
