Spring Boot Challenge for Bedaan 
==========
This project uses Postgresql as DB and Apache kafka to streaming messages.
    
## Installation

Install dependencies

    install latest Postgresql
    
    install latest Apache Kafka


## After Installation
Start Zookeeper and Kafka server in separate terminals 

    bin/zookeeper-server-start.sh config/zookeeper.properties

    bin/kafka-server-start.sh config/server.properties
    
Then Run The project...

List of endpoints can be found at

    http://localhost:8080/swagger-ui.html