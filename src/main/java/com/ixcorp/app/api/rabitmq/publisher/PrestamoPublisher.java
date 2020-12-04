package com.ixcorp.app.api.rabitmq.publisher;

import com.ixcorp.app.api.rabitmq.ConfigureRabbitMq;
import com.ixcorp.app.api.dto.PrestamoDTO;
import com.ixcorp.app.api.dto.PrestamoStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PrestamoPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String generarPrestamo(PrestamoDTO prestamo) {
        prestamo.setPrestamoGuiId(UUID.randomUUID().toString());

        PrestamoStatus prestamoStatus = new PrestamoStatus(prestamo, "PROCESS", "prestamo exitoso!");

        rabbitTemplate.convertAndSend(ConfigureRabbitMq.EXCHANGE, ConfigureRabbitMq.ROUTING_KEY, prestamoStatus);

        return "Success!!";
    }
}
