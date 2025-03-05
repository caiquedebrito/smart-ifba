package com.ifba.smart.api.adapters;

import jakarta.jms.BytesMessage;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.ifba.smart.api.humidity.domain.HumiditySensorService;
import com.ifba.smart.api.solo.domain.SoloSensorService;
import com.ifba.smart.api.sound.domain.SoundSensorService;
import com.ifba.smart.api.temperature.domain.TemperatureSensorService;

@Component
public class BrokerConsumerAdapater {
    @Autowired
    JmsTemplate jms;

    private final HumiditySensorService humiditySensorService;
    private final SoloSensorService soloSensorService;
    private final SoundSensorService soundSensorService;
    private final TemperatureSensorService temperatureSensorService;

    public BrokerConsumerAdapater(
        HumiditySensorService humiditySensorService, 
        SoloSensorService soloSensorService, 
        SoundSensorService soundSensorService, 
        TemperatureSensorService temperatureSensorService
    ) {
        this.humiditySensorService = humiditySensorService;
        this.soloSensorService = soloSensorService;
        this.soundSensorService = soundSensorService;
        this.temperatureSensorService = temperatureSensorService;
    }

    @JmsListener(destination = "sensores.ruido::ruido")
    public void noiseSensorConsume(Message message) throws JMSException {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            soundSensorService.save(Float.parseFloat(textMessage.getText()));
        } else if (message instanceof BytesMessage) {
            BytesMessage bytesMessage = (BytesMessage) message;
            byte[] byteData = new byte[(int) bytesMessage.getBodyLength()];
            bytesMessage.readBytes(byteData);
            String decodedMessage = new String(byteData, java.nio.charset.StandardCharsets.UTF_8);
            soundSensorService.save(Float.parseFloat(decodedMessage));
        } 

    }

    @JmsListener(destination = "sensores.temperatura::temperatura")
    public void temperatureSensorConsume(Message message) throws JMSException {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            temperatureSensorService.save(Float.parseFloat(textMessage.getText()));
        } else if (message instanceof BytesMessage) {
            BytesMessage bytesMessage = (BytesMessage) message;
            byte[] byteData = new byte[(int) bytesMessage.getBodyLength()];
            bytesMessage.readBytes(byteData);
            String decodedMessage = new String(byteData, java.nio.charset.StandardCharsets.UTF_8);
            temperatureSensorService.save(Float.parseFloat(decodedMessage));
        } 
    }

    @JmsListener(destination = "sensores.solo::solo")
    public void soloSensorConsume(Message message) throws JMSException {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            soloSensorService.save(Float.parseFloat(textMessage.getText()));
        } else if (message instanceof BytesMessage) {
            BytesMessage bytesMessage = (BytesMessage) message;
            byte[] byteData = new byte[(int) bytesMessage.getBodyLength()];
            bytesMessage.readBytes(byteData);
            String decodedMessage = new String(byteData, java.nio.charset.StandardCharsets.UTF_8);
            soloSensorService.save(Float.parseFloat(decodedMessage));
            
        } 
    }

    @JmsListener(destination = "sensores.umidade::umidade")
    public void humiditySensorConsume(Message message) throws JMSException {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            humiditySensorService.save(Float.parseFloat(textMessage.getText()));
        } else if (message instanceof BytesMessage) {
            BytesMessage bytesMessage = (BytesMessage) message;
            byte[] byteData = new byte[(int) bytesMessage.getBodyLength()];
            bytesMessage.readBytes(byteData);
            String decodedMessage = new String(byteData, java.nio.charset.StandardCharsets.UTF_8);
            humiditySensorService.save(Float.parseFloat(decodedMessage));
        } 
    }
}
