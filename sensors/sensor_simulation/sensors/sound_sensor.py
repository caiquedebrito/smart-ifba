from sensor_simulation.clients import MqttClient
from sensor_simulation.sensors.base_sensor import BaseSensor

from random import uniform

class SoundSensor(BaseSensor):
  
  def __init__(self, 
               mqtt_client: MqttClient, topic: str, interval: float = 10.0):
    super().__init__(mqtt_client, topic, interval)
  
  def generate_data(self) -> float:
    return uniform(30.0, 120.0)