from sensor_simulation import SensorManager
from sensor_simulation.clients import MqttClient
from sensor_simulation.sensors import HumiditySensor, TemperatureSensor, SoloSensor, SoundSensor

if __name__ == '__main__':
    mqtt_client = MqttClient('127.0.0.1', port=1883, password='admin', username='admin')
    mqtt_client.connect()
    mqtt_client.loop_start()

    sound_sensor = SoundSensor(mqtt_client, 'sensores/ruido')
    temperature_sensor = TemperatureSensor(mqtt_client, 'sensores/temperatura')
    humidity_sensor = HumiditySensor(mqtt_client, 'sensores/umidade', interval=10.0)
    solo_sensor = SoloSensor(mqtt_client, 'sensores/solo')

    sensor_manager = SensorManager()
    sensor_manager.add_sensor(sound_sensor)
    sensor_manager.add_sensor(humidity_sensor)
    sensor_manager.add_sensor(temperature_sensor)
    sensor_manager.add_sensor(solo_sensor) 

    try:
        sensor_manager.run()
    except KeyboardInterrupt:
        sensor_manager.stop_all()