# Springboot RabbitMQ implementation

- In this Springboot project, I have created a RabbitMQ producer and consumer using the Springboot AMQP library.

- A Restcontroller is used to call the producer (of which there are 2 types - a String message producer and a JSON message producer)

- These messages will then be received and processed by respective consumers

- I pulled the RabbitMQ image from docker hub and ran it as a docker container while running this project
