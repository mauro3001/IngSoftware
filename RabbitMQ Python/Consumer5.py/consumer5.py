import queue
from paramiko import Channel
import pika

def message_received(ch,method,properties,body):
    print(f"Consumidor 5 para Spring ha recibido un nuevo mensaje: {body}")

connection_parameters = pika.ConnectionParameters('localhost')

connection = pika.BlockingConnection(connection_parameters)

channel = connection.channel()

channel.queue_declare(queue='queue5',durable=True)

channel.basic_consume(queue='queue5', auto_ack=True, 
    on_message_callback=message_received)

print("Empezando a Consumir informacion")

channel.start_consuming()