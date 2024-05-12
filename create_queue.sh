#!/bin/bash

# Espera o Kafka e o Zookeeper estarem totalmente operacionais
echo "Criando fila sqs..."

awslocal sqs create-queue --queue-name devOpportunityQueue

echo "Fila criada com sucesso."