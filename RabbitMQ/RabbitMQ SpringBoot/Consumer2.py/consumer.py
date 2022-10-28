import queue
from paramiko import Channel
import pika

def message_received(ch,method,properties,body):
    print(f"Consumidor 2 para Spring ha recibido un nuevo mensaje: {body}")

connection_parameters = pika.ConnectionParameters('localhost')

connection = pika.BlockingConnection(connection_parameters)

channel = connection.channel()

channel.queue_declare(queue='queue2',durable=True)

channel.basic_consume(queue='queue2', auto_ack=True, 
    on_message_callback=message_received)

print("Empezando a Consumir informacion")

channel.start_consuming()