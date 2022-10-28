from tokenize import String
from paramiko import Channel
#from datatime import datatime, timezone
import pika
import json

#marca = datatime.now(timezone.utc).astimezone()

connection_parameters = pika.ConnectionParameters('localhost')

connection = pika.BlockingConnection(connection_parameters)

channel = connection.channel()

channel.queue_declare(queue='queue4',durable=True)
channel.queue_declare(queue='queue5',durable=True)


message = '{"mensaje":"prueba","en":"python"}'

channel.basic_publish(exchange='', routing_key='queue4', body=message)
channel.basic_publish(exchange='', routing_key='queue5', body=message)

print(f"enviando mensaje: {message}")

connection.close()